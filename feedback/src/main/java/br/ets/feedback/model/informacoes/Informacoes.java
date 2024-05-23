package br.ets.feedback.model.informacoes;

import br.ets.feedback.model.informacoes.dtos.DadosInformacoes;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Informacoes {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    public Informacoes(DadosInformacoes dados) {
        this.disciplina = dados.disciplina();
        this.trilha = dados.trilha();
        this.faculdade = dados.faculdade();
        this.turma = dados.turma();
    }
}
