package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.auth.dtos.LoginRequestDto;
import pi.procurarteapi.app.auth.dtos.LoginResponseDto;
import pi.procurarteapi.app.auth.services.LoginService;
import pi.procurarteapi.infra.entities.Musician;

@RestController
@CrossOrigin("*")
@Api(value = "Auth")
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) throws Exception {
        try {

            UsernamePasswordAuthenticationToken usetAuthToken = 
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());


            Authentication auth = this.authManager.authenticate(usetAuthToken);
 
            var musician = (Musician)auth.getPrincipal();

           // LoginResponseDto response = loginService.execute(request);

           // return ResponseEntity.status(HttpStatus.OK).body(response);

           return tokenService.gererToken(musician);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}
