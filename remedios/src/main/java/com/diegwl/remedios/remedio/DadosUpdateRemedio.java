package com.diegwl.remedios.remedio;

import jakarta.validation.constraints.PositiveOrZero;

public record DadosUpdateRemedio(
        long id,
        String nome,
        Via via,
        @PositiveOrZero
        Integer quantidade
) {
}
