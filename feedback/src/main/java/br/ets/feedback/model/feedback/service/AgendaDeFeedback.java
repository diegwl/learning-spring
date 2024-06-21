package br.ets.feedback.model.feedback.service;

import br.ets.feedback.model.aprendiz.repository.AprendizRepository;
import br.ets.feedback.model.feedback.Feedback;
import br.ets.feedback.model.feedback.dtos.DadosAgendamentoFeedback;
import br.ets.feedback.model.feedback.repository.FeedbackRepository;
import br.ets.feedback.model.feedback.validators.ValidarAgendamentoDeFeedback;
import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeFeedback {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private InstrutorRepository instrutorRepository;
    @Autowired
    private AprendizRepository aprendizRepository;

    @Autowired
    private List<ValidarAgendamentoDeFeedback> validadores;

    @Transactional
    public void agendar(DadosAgendamentoFeedback dadosAgendamentoFeedback) {
        if (!aprendizRepository.existsById(dadosAgendamentoFeedback.idAprendiz())) {
            throw new RuntimeException("ID do aprendiz não existe");
        }

        if (!instrutorRepository.existsById(dadosAgendamentoFeedback.idInstrutor())) {
            throw new RuntimeException("ID do instrutor não existe");
        }

        validadores.forEach(v -> v.validar(dadosAgendamentoFeedback));

        var aprendiz = aprendizRepository.findByIdAndAtivoTrue(dadosAgendamentoFeedback.idAprendiz());
        var instrutor = escolherInstrutor(dadosAgendamentoFeedback);
        var agendamento = dadosAgendamentoFeedback.datetime();

        var feedback = new Feedback(instrutor, aprendiz, agendamento);

        feedbackRepository.save(feedback);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoFeedback dados) {
        if (dados.idInstrutor() != 0) {
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }
        if (dados.curso() != null) {
            throw new RuntimeException("O curso é obrigatório quando o instrutor não foi selecionado");
        }

        return instrutorRepository.escolherInstrutorAleatorioLivreNaData(dados.curso(), dados.datetime());
    }
}
