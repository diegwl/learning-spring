package br.ets.feedback.model.informacoes.aprendiz.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosInformacoesAprendiz(
        @NotBlank Integer idade,
        @NotBlank String trilha,
        @NotBlank String faculdade,
        @NotBlank String turma
) {
}
