package pi.procurarteapi.app.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Autowired
    //private
    
    //Faz a liberação das paginas que podem ser acessadas com ou sem autenticação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
       return http.csrf().disable()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and().authorizeRequests()
              .antMatchers(HttpMethod.POST,"/auth")
              .permitAll()
              .antMatchers(HttpMethod.GET, "/musician")
              .permitAll()
              .antMatchers(HttpMethod.POST, "/musician")
              .permitAll()
              .anyRequest().authenticated().and().build(); 
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }

}
