package br.ets.feedback.model.feedback.validators;

import br.ets.feedback.model.feedback.dtos.DadosAgendamentoFeedback;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioFeedback implements ValidarAgendamentoDeFeedback{

    @Override
    public void validar(DadosAgendamentoFeedback dadosAgendamentoFeedback) {
        var dataFeedback = dadosAgendamentoFeedback.datetime();
        var domingo = dataFeedback.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var sabado = dataFeedback.getDayOfWeek().equals(DayOfWeek.SATURDAY);
        var antesDoHorario = dataFeedback.getHour() < 8;
        var depoisDoHorario = dataFeedback.getHour() > 17;

        if(domingo || sabado || antesDoHorario || depoisDoHorario) {
            throw new RuntimeException("Feedback agendado fora do horário");
        }
    }
}
