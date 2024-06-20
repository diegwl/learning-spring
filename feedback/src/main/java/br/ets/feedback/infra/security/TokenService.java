package br.ets.feedback.infra.security;

import br.ets.feedback.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withIssuer("feedback")
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token", e);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("feedback")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();


        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token inválido ou expirado", e);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
