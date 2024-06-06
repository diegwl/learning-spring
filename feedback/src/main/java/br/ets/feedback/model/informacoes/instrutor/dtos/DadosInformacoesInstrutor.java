package br.ets.feedback.model.informacoes.instrutor.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosInformacoesInstrutor(@NotBlank String disciplina,
                                        @NotBlank String trilha,
                                        @NotBlank String faculdade,
                                        @NotBlank String turma) {
}
