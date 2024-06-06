package br.ets.feedback.model.informacoes.aprendiz;

import br.ets.feedback.model.informacoes.aprendiz.dtos.DadosAtualizacaoInformacoesAprendiz;
import br.ets.feedback.model.informacoes.aprendiz.dtos.DadosInformacoesAprendiz;
import br.ets.feedback.model.informacoes.instrutor.dtos.DadosAtualizacaoInformacoesInstrutor;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class InformacoesAprendiz {
    private Integer idade;
    private String trilha;
    private String faculdade;
    private String turma;

    public InformacoesAprendiz(DadosInformacoesAprendiz dados) {
        this.idade = dados.idade();
        this.trilha = dados.trilha();
        this.faculdade = dados.faculdade();
        this.turma = dados.turma();
    }

    public void atualizar(DadosAtualizacaoInformacoesAprendiz informacoes) {
        this.idade = informacoes.idade() != null ? informacoes.idade() : this.idade;
        this.trilha = informacoes.trilha() != null ? informacoes.trilha() : this.trilha;
        this.faculdade = informacoes.faculdade() != null ? informacoes.faculdade() : this.faculdade;
        this.turma = informacoes.turma() != null ? informacoes.turma() : this.turma;
    }
}
