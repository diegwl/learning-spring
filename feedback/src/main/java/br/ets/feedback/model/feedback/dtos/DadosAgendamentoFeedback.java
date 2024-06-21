package br.ets.feedback.model.feedback.dtos;

import br.ets.feedback.model.enums.CursoEnum;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoFeedback(
        @NotNull Integer idInstrutor,
        @NotNull Integer idAprendiz,
        @NotNull @Future LocalDateTime datetime,
        CursoEnum curso) {
}
