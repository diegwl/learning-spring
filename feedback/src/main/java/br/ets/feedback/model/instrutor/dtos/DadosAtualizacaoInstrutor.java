package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.informacoes.instrutor.dtos.DadosAtualizacaoInformacoesInstrutor;
import br.ets.feedback.model.enums.CursoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoInstrutor(@NotNull Integer id,
                                        String nome,
                                        @Email String email,
                                        @Pattern(regexp = "\\d{8}") String edv,
                                        CursoEnum curso,
                                        Boolean ferias,
                                        DadosAtualizacaoInformacoesInstrutor informacoes) {
}
