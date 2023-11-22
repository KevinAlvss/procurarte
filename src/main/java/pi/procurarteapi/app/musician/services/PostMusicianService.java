package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
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
             Musician saveMusician = musicianRepository.save(musician);
             return saveMusician;    
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
