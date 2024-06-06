package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.informacoes.instrutor.InformacoesInstrutor;
import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.enums.CursoEnum;

public record DadosDetalhadosInstrutor(Integer id,
                                       String nome,
                                       String email,
                                       String edv,
                                       CursoEnum curso,
                                       Boolean ferias,
                                       Boolean ativo,
                                       InformacoesInstrutor informacoesInstrutor) {
    public DadosDetalhadosInstrutor(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getEdv(), instrutor.getCurso(), instrutor.getFerias(), instrutor.getAtivo(), instrutor.getInformacoesInstrutor());
    }
}
