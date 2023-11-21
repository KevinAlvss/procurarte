package pi.procurarteapi.app.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    private IMusicianRepository musicianRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return musicianRepository.findByEmail(username);
    }
    
}
