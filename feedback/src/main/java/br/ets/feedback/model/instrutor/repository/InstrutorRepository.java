package br.ets.feedback.model.instrutor.repository;

import br.ets.feedback.model.enums.CursoEnum;
import br.ets.feedback.model.instrutor.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
    Page<Instrutor> findAllByAtivoTrue(Pageable pageable);
    Page<Instrutor> findAllByAtivoFalse(Pageable pageable);
    Instrutor findByIdAndAtivoTrue(Integer id);
    Instrutor findByIdAndAtivoFalse(Integer id);
    @Query("""
            select i from Instrutor i
            where i.ativo=true
            and i.curso = :curso
            and i.id not in(
                select f.instrutor.id from Feedback f
                where f.dateTime =:datetime
            )
            order by rand()
            limit 1
            """)
    Instrutor escolherInstrutorAleatorioLivreNaData(CursoEnum curso, LocalDateTime datetime);
}
