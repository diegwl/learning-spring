package br.ets.feedback.model.instrutor.repository;

import br.ets.feedback.model.instrutor.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
}
