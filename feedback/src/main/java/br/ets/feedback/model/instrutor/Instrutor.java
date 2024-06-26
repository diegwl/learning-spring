package br.ets.feedback.model.instrutor;

import br.ets.feedback.model.informacoes.instrutor.InformacoesInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosAtualizacaoInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.enums.CursoEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity(name = "Instrutor")
@Table(name = "instrutor")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Embedded
    private InformacoesInstrutor informacoesInstrutor;
    private Boolean ferias;
    private Boolean ativo;

    public Instrutor(DadosCadastroInstrutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.edv = dados.edv();
        this.curso = dados.curso();
        this.informacoesInstrutor = new InformacoesInstrutor(dados.informacoes());
        this.ferias = dados.ferias();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoInstrutor dados) {
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
            this.informacoesInstrutor.atualizar(dados.informacoes());
        }
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }
}
