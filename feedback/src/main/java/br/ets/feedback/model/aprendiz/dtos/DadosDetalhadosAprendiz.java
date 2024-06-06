package br.ets.feedback.model.aprendiz.dtos;

import br.ets.feedback.model.aprendiz.Aprendiz;
import br.ets.feedback.model.enums.CursoEnum;
import br.ets.feedback.model.informacoes.aprendiz.InformacoesAprendiz;
import br.ets.feedback.model.informacoes.instrutor.InformacoesInstrutor;

public record DadosDetalhadosAprendiz(Integer id,
                                      String nome,
                                      String email,
                                      String edv,
                                      CursoEnum curso,
                                      Boolean ferias,
                                      Boolean ativo,
                                      InformacoesAprendiz informacoesInstrutor) {
    public DadosDetalhadosAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getId(), aprendiz.getNome(), aprendiz.getEmail(), aprendiz.getEdv(), aprendiz.getCurso(), aprendiz.getFerias(), aprendiz.getAtivo(), aprendiz.getInformacoes());
    }
}
