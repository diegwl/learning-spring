package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.informacoes.dtos.DadosInformacoes;
import br.ets.feedback.model.instrutor.enums.CursoEnum;

public record DadosCadastroInstrutor(String nome, String email, String edv, CursoEnum curso, DadosInformacoes informacoes, Boolean ferias) {
}
