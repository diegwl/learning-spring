package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.enums.CursoEnum;

public record DadosListagemInstrutor(Integer id,
                                    String nome,
                                    String email,
                                     String edv,
                                     CursoEnum curso,
                                     Boolean ferias,
                                     Boolean ativo) {
    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getEdv(), instrutor.getCurso(), instrutor.getFerias(), instrutor.getAtivo());
    }
}
