package pi.procurarteapi.app.auth.services;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.bouncycastle.math.ec.rfc8032.Ed25519.Algorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;


import pi.procurarteapi.infra.entities.Musician;

@Service
public class TokenService {

    public String gererToken(Musician musician) {
        return null; 
    }
    
}
