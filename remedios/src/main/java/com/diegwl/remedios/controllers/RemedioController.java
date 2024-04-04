package com.diegwl.remedios.controllers;

import com.diegwl.remedios.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping("/")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }

    @GetMapping("/")
    public List<DadosListagemRemedio> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping("/")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosUpdateRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}/")
    @Transactional
    public void excluir(@PathVariable @Valid Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}/")
    @Transactional
    public void inativar(@PathVariable @Valid Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }

    @GetMapping("/inativos/")
    public List<DadosListagemRemedio> listarInativos() {
        return repository.findAllByAtivoFalse().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping("ativar/{id}/")
    @Transactional
    public void ativar(@PathVariable @Valid Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.ativar();
    }
}
