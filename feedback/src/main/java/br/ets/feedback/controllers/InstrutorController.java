package br.ets.feedback.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @PostMapping
    public void cadastrar(@RequestBody String json) {
        System.out.println(json);
    }
}
