package br.ets.feedback.model.usuario.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(@NotBlank String login,
                                @NotBlank String senha) {
}
