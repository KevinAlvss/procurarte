package pi.procurarteapi.app.auth.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import pi.procurarteapi.infra.entities.Musician;

@Service
public class TokenService {

    public String generateToken(Musician musician) {

        return JWT.create()
                .withIssuer("Musico")
                .withSubject(musician.getUsername())
                .withClaim("id", musician.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("secreta"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("Musico").build().verify(token).getSubject();
    }

}
