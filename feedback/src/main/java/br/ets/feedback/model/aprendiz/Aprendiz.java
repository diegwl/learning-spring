package br.ets.feedback.model.aprendiz;

import br.ets.feedback.model.aprendiz.dtos.DadosAtualizacaoAprendiz;
import br.ets.feedback.model.informacoes.aprendiz.InformacoesAprendiz;
import br.ets.feedback.model.informacoes.instrutor.InformacoesInstrutor;
import br.ets.feedback.model.enums.CursoEnum;
import br.ets.feedback.model.aprendiz.dtos.DadosCadastroAprendiz;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity(name = "Aprendiz")
@Table(name = "aprendiz")
public class Aprendiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Embedded
    private InformacoesAprendiz informacoes;
    private Boolean ferias;
    private Boolean ativo;

    public Aprendiz(DadosCadastroAprendiz dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.edv = dados.edv();
        this.curso = dados.curso();
        this.informacoes = new InformacoesAprendiz(dados.informacoes());
        this.ferias = dados.ferias();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoAprendiz dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.edv() != null) {
            this.edv = dados.edv();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
        if (dados.ferias() != null) {
            this.ferias = dados.ferias();
        }
        if (dados.informacoes() != null) {
            this.informacoes.atualizar(dados.informacoes());
        }
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }
}
