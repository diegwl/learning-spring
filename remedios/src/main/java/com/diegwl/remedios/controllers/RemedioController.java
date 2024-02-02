package com.diegwl.remedios.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegwl.remedios.controllers.remedio.DadosCadastroRemedio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/remedios")
public class RemedioController {
    @PostMapping("/")    
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
        System.out.println(dados);
    }
}
