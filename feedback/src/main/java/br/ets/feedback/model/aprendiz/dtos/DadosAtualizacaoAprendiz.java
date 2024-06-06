package br.ets.feedback.model.aprendiz.dtos;

import br.ets.feedback.model.enums.CursoEnum;
import br.ets.feedback.model.informacoes.aprendiz.dtos.DadosAtualizacaoInformacoesAprendiz;
import br.ets.feedback.model.informacoes.instrutor.dtos.DadosAtualizacaoInformacoesInstrutor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoAprendiz(@NotNull Integer id,
                                       String nome,
                                       @Email String email,
                                       @Pattern(regexp = "\\d{8}") String edv,
                                       CursoEnum curso,
                                       Boolean ferias,
                                       DadosAtualizacaoInformacoesAprendiz informacoes) {
}
