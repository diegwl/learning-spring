package br.ets.feedback.controllers;

import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.dtos.DadosAtualizacaoInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosDetalhadosInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosListagemInstrutor;
import br.ets.feedback.model.instrutor.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @Transactional
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<DadosDetalhadosInstrutor> cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor, UriComponentsBuilder uriBuilder) {
        Instrutor instrutor = new Instrutor(dadosCadastroInstrutor);
        repository.save(instrutor);

        var uri = uriBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar(@PageableDefault(size = 3, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadosInstrutor> procurar(@PathVariable @Valid Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new DadosDetalhadosInstrutor(instrutor.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(instrutor.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosInstrutor> atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        var instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosInstrutor(instrutor));
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Instrutor> inativar(@PathVariable @Valid Integer id) {
        var instrutor = (Instrutor) repository.findByIdAndAtivoTrue(id);
        instrutor.desativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInativos(@PageableDefault(size = 3, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<Instrutor> ativar(@PathVariable @Valid Integer id) {
        var instrutor = (Instrutor) repository.findByIdAndAtivoFalse(id);
        instrutor.ativar();
        return ResponseEntity.noContent().build();
    }
}
