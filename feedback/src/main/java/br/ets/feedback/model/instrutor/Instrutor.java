package br.ets.feedback.model.instrutor;

import br.ets.feedback.model.informacoes.Informacoes;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.instrutor.enums.CursoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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
    private Informacoes informacoes;

    public Instrutor(DadosCadastroInstrutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.edv = dados.edv();
        this.curso = dados.curso();
        this.informacoes = new Informacoes(dados.informacoes());
    }
}
