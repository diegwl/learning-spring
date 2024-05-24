package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.informacoes.dtos.DadosInformacoes;
import br.ets.feedback.model.instrutor.enums.CursoEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record DadosCadastroInstrutor(@NotBlank String nome,
                                     @NotBlank @Email String email,
                                     @NotBlank @Pattern(regexp = "\\d{8}") String edv,
                                     @NotNull CursoEnum curso,
                                     @NotNull @Valid DadosInformacoes informacoes,
                                     @NotNull Boolean ferias) {
}
