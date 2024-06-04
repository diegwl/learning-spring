package br.ets.feedback.model.informacoes.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoInformacoes(String disciplina,
                                          String trilha,
                                          String faculdade,
                                          String turma) {
}
