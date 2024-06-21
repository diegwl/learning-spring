package br.ets.feedback.model.feedback.validators;

import br.ets.feedback.model.feedback.dtos.DadosAgendamentoFeedback;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedencia implements ValidarAgendamentoDeFeedback {

    @Override
    public void validar(DadosAgendamentoFeedback dadosAgendamentoFeedback) {
        var data = dadosAgendamentoFeedback.datetime();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, data).toMinutes();

        if (diferenca < 30 && diferenca >= 0) {
            throw new RuntimeException("Feedback deve ser agendado com antecedência de 30 minutos");
        }

        if (diferenca < 0) {
            throw new RuntimeException("Feedback deve ser agendado no futuro");
        }
    }
}
