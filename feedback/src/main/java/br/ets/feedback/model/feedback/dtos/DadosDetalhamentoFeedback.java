package br.ets.feedback.model.feedback.dtos;

import br.ets.feedback.model.feedback.Feedback;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhamentoFeedback(
        Integer id,
        Integer idInstrutor,
        Integer idAprendiz,
        LocalDateTime datetime) {
    public DadosDetalhamentoFeedback(Feedback feedback) {
        this(feedback.getId(), feedback.getInstrutor().getId(), feedback.getAprendiz().getId(), feedback.getDateTime());
    }
}
