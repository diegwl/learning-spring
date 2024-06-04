package br.ets.feedback.model.instrutor.repository;

import br.ets.feedback.model.instrutor.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
    Page<Instrutor> findAllByAtivoTrue(Pageable pageable);
    Page<Instrutor> findAllByAtivoFalse(Pageable pageable);
}
