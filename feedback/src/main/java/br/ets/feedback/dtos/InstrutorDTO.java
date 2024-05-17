package br.ets.feedback.dtos;

import br.ets.feedback.enums.CursoEnum;

public record InstrutorDTO(String nome, String email, String edv, CursoEnum curso, InformacoesInstrutorDTO informacoes) {
}
