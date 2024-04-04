package com.diegwl.remedios.controllers;

import com.diegwl.remedios.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping("/")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }

    @GetMapping("/")
    public ResponseEntity<List<DadosListagemRemedio>>  listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosUpdateRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}/")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable @Valid Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}/")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable @Valid Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inativos/")
    public ResponseEntity<List<DadosListagemRemedio>> listarInativos() {
        var lista = repository.findAllByAtivoFalse().stream().map(DadosListagemRemedio::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping("/ativar/{id}/")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> ativar(@PathVariable @Valid Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.ativar();

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
}
