package br.ets.feedback.model.feedback.repository;

import br.ets.feedback.model.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
