package pi.procurarteapi.app.musician.services;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.interfaces.IPostMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class PostMusicianService implements IPostMusicianService{
    
    @Autowired
    private IMusicianRepository musicianRepository;

    public PostMusicianService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public Musician execute(Musician musician) throws Exception {
        try {

            
            PasswordEncoder passEncoder = new BCryptPasswordEncoder();
            String criptoPass = passEncoder.encode(musician.getPassword());
            musician.setPassword(criptoPass);

            Musician saveMusician = musicianRepository.save(musician);
                 return saveMusician; 
                
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
