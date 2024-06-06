package br.ets.feedback.model.informacoes.instrutor;

import br.ets.feedback.model.informacoes.instrutor.dtos.DadosAtualizacaoInformacoesInstrutor;
import br.ets.feedback.model.informacoes.instrutor.dtos.DadosInformacoesInstrutor;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class InformacoesInstrutor {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    public InformacoesInstrutor(DadosInformacoesInstrutor dados) {
        this.disciplina = dados.disciplina();
        this.trilha = dados.trilha();
        this.faculdade = dados.faculdade();
        this.turma = dados.turma();
    }

    public void atualizar(DadosAtualizacaoInformacoesInstrutor informacoes) {
        this.disciplina = informacoes.disciplina() != null ? informacoes.disciplina() : this.disciplina;
        this.trilha = informacoes.trilha() != null ? informacoes.trilha() : this.trilha;
        this.faculdade = informacoes.faculdade() != null ? informacoes.faculdade() : this.faculdade;
        this.turma = informacoes.turma() != null ? informacoes.turma() : this.turma;
    }
}
