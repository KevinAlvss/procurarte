package pi.procurarteapi.app.auth.services;



import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import pi.procurarteapi.infra.entities.Musician;

@Service
public class TokenService {

    public String gererToken(Musician musician) {
        return JWT.create()
                .withIssuer("Musico")
                .withSubject(musician.getUsername())
                .withClaim("id", musician.getId())
                .withExpiresAt(LocalDateTime.now()
                    .plusMinutes(10)
                    .toInstant(ZoneOffset.of("-33:00"))
                ).sign(null);
                
    }
    
}
