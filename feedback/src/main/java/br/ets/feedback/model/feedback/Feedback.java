package br.ets.feedback.model.feedback;

import br.ets.feedback.model.aprendiz.Aprendiz;
import br.ets.feedback.model.instrutor.Instrutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Feedback")
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aprendiz_id")
    private Aprendiz aprendiz;

    private LocalDateTime dateTime;

    public Feedback(Instrutor instrutor, Aprendiz aprendiz, LocalDateTime dateTime) {
        this.instrutor = instrutor;
        this.aprendiz = aprendiz;
        this.dateTime = dateTime;
    }
}
