package br.ets.feedback.controllers;

import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.instrutor.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void cadastrar(@RequestBody DadosCadastroInstrutor dadosCadastroInstrutor) {
        Instrutor instrutor = new Instrutor(dadosCadastroInstrutor);
        repository.save(instrutor);
    }

    @GetMapping
    public List<Instrutor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Instrutor procurar(@PathVariable Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return instrutor.get();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(instrutor.get());
    }
}
