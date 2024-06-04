package br.ets.feedback.model.informacoes;

import br.ets.feedback.model.informacoes.dtos.DadosAtualizacaoInformacoes;
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

    public void atualizar(DadosAtualizacaoInformacoes informacoes) {
        if (informacoes.disciplina() != null) {
            this.disciplina = informacoes.disciplina();
        }
        if (informacoes.faculdade() != null) {
            this.faculdade = informacoes.faculdade();
        }
        if (informacoes.trilha() != null) {
            this.trilha = informacoes.trilha();
        }
        if (informacoes.turma() != null) {
            this.turma = informacoes.turma();
        }
    }
}
