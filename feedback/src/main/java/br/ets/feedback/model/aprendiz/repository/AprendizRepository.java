package br.ets.feedback.model.aprendiz.repository;

import br.ets.feedback.model.aprendiz.Aprendiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AprendizRepository extends JpaRepository<Aprendiz, Integer> {
    Page<Aprendiz> findAllByAtivoTrue(Pageable pageable);
    Page<Aprendiz> findAllByAtivoFalse(Pageable pageable);
}
