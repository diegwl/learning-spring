package br.ets.feedback.model.aprendiz.dtos;

import br.ets.feedback.model.enums.CursoEnum;
import br.ets.feedback.model.informacoes.aprendiz.dtos.DadosInformacoesAprendiz;
import br.ets.feedback.model.informacoes.instrutor.dtos.DadosInformacoesInstrutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAprendiz(@NotBlank String nome,
                                    @NotBlank @Email String email,
                                    @NotBlank @Pattern(regexp = "\\d{8}") String edv,
                                    @NotNull CursoEnum curso,
                                    @NotNull @Valid DadosInformacoesAprendiz informacoes,
                                    @NotNull Boolean ferias) {
}
