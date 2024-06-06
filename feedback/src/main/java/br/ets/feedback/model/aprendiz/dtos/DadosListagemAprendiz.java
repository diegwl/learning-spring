package br.ets.feedback.model.aprendiz.dtos;

import br.ets.feedback.model.aprendiz.Aprendiz;
import br.ets.feedback.model.enums.CursoEnum;

public record DadosListagemAprendiz(Integer id,
                                    String nome,
                                    String email,
                                    String edv,
                                    CursoEnum curso,
                                    Boolean ferias,
                                    Boolean ativo) {
    public DadosListagemAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getId(), aprendiz.getNome(), aprendiz.getEmail(), aprendiz.getEdv(), aprendiz.getCurso(), aprendiz.getFerias(), aprendiz.getAtivo());
    }
}
