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
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping("/")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosUpdateRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable @Valid Long id) {
        repository.deleteById(id);
    }
}
