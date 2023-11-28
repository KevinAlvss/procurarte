package pi.procurarteapi.app.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.auth.dtos.LoginRequestDto;
import pi.procurarteapi.app.auth.dtos.LoginResponseDto;
import pi.procurarteapi.infra.entities.Musician;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    public LoginResponseDto execute(LoginRequestDto request) throws Exception {
        try {
            UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword());

            Authentication auth = this.authManager.authenticate(userAuthToken);

            var musician = (Musician) auth.getPrincipal();
            String token = tokenService.generateToken(musician);

            LoginResponseDto response = new LoginResponseDto();
            response.setToken(token);
            response.setUserId(musician.getId());

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
