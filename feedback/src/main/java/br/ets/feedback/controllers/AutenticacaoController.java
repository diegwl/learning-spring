package br.ets.feedback.controllers;

import br.ets.feedback.infra.security.DadosTokenJWT;
import br.ets.feedback.infra.security.TokenService;
import br.ets.feedback.model.usuario.Usuario;
import br.ets.feedback.model.usuario.dtos.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var jwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(jwt));
    }
}
