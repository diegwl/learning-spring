package com.diegwl.remedios.controllers;

import com.diegwl.remedios.remedio.Remedio;
import com.diegwl.remedios.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegwl.remedios.remedio.DadosCadastroRemedio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping("/")
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }
}
