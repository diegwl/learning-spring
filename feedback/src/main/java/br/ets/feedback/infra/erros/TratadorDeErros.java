package br.ets.feedback.infra.erros;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> Error404NotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }

    public record DadosErros(String field, String message) {
        public DadosErros(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> tratarRegraDaAplicacao(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
