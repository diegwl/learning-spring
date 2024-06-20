package br.ets.feedback.model.informacoes.aprendiz.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosInformacoesAprendiz(
        @NotNull Integer idade,
        @NotBlank String trilha,
        @NotBlank String faculdade,
        @NotBlank String turma
) {
}
