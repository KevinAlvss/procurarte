package pi.procurarteapi.app.auth.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import pi.procurarteapi.app.auth.services.TokenService;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Component
public class FilterToken extends OncePerRequestFilter{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IMusicianRepository musicianRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {

        String token;
        var authorizationHeader =  request.getHeader("Authorization");

        if(authorizationHeader != null){
            token =  authorizationHeader.replace("Bearer ", "");
            var subject =  tokenService.getSubject(token);

            var musician =  musicianRepository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(musician,null, musician.getAuthorities());
        
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
