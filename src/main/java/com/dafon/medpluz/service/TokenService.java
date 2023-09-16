package com.dafon.medpluz.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.algorithms.Algorithm;
import com.dafon.medpluz.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.*;
@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API Med Pluz")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt: " + exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusMinutes(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
