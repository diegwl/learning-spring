package com.diegwl.remedios.remedio;

public record DadosUpdateRemedio(
        long id,
        String nome,
        Via via,
        Integer quantidade
) {
}
