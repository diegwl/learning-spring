package br.ets.feedback.controllers;

import br.ets.feedback.model.aprendiz.Aprendiz;
import br.ets.feedback.model.aprendiz.dtos.DadosAtualizacaoAprendiz;
import br.ets.feedback.model.aprendiz.dtos.DadosCadastroAprendiz;
import br.ets.feedback.model.aprendiz.dtos.DadosDetalhadosAprendiz;
import br.ets.feedback.model.aprendiz.dtos.DadosListagemAprendiz;
import br.ets.feedback.model.aprendiz.repository.AprendizRepository;
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

@RestController
@RequestMapping("/aprendiz")
public class AprendizController {

    @Autowired
    private AprendizRepository repository;

    @Transactional
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<DadosDetalhadosAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dadosCadastroAprendiz, UriComponentsBuilder uriBuilder) {
        Aprendiz aprendiz = new Aprendiz(dadosCadastroAprendiz);
        repository.save(aprendiz);

        var uri = uriBuilder.path("/aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosAprendiz(aprendiz));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAprendiz>> listar(@PageableDefault(size = 3, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemAprendiz::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadosAprendiz> procurar(@PathVariable @Valid Integer id) {
        var aprendiz = repository.findById(id);
        if (aprendiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new DadosDetalhadosAprendiz(aprendiz.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var aprendiz = repository.findById(id);
        if (aprendiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(aprendiz.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosAprendiz> atualizar(@RequestBody @Valid DadosAtualizacaoAprendiz dados) {
        var aprendiz = repository.getReferenceById(dados.id());
        aprendiz.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosAprendiz(aprendiz));
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Aprendiz> inativar(@PathVariable @Valid Integer id) {
        var aprendiz = repository.findByIdAndAtivoTrue(id);
        aprendiz.desativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosListagemAprendiz>> listarInativos(@PageableDefault(size = 3, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemAprendiz::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<Aprendiz> ativar(@PathVariable @Valid Integer id) {
        var aprendiz = repository.findByIdAndAtivoFalse(id);
        aprendiz.ativar();
        return ResponseEntity.noContent().build();
    }

}
