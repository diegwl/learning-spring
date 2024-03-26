package com.diegwl.remedios.controllers;

import com.diegwl.remedios.remedio.Remedio;
import com.diegwl.remedios.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diegwl.remedios.remedio.DadosCadastroRemedio;

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

    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAll();
    }


}
