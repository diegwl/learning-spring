package com.diegwl.remedios.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(

        Long id,

        String nome,

        Via via,

        String lote,

        Integer quantidade,

        LocalDate validade,

        Laboratorio laboratorio
) {
    public DadosListagemRemedio(Remedio remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio()
        );
    }
}
