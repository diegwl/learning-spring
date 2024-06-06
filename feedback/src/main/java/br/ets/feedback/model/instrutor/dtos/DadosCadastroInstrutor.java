package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.informacoes.instrutor.dtos.DadosInformacoesInstrutor;
import br.ets.feedback.model.enums.CursoEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(@NotBlank String nome,
                                     @NotBlank @Email String email,
                                     @NotBlank @Pattern(regexp = "\\d{8}") String edv,
                                     @NotNull CursoEnum curso,
                                     @NotNull @Valid DadosInformacoesInstrutor informacoes,
                                     @NotNull Boolean ferias) {
}
