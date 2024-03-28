package com.diegwl.remedios.remedio;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosCadastroRemedio(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        @PositiveOrZero
        Integer quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {

}
