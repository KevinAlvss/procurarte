package pi.procurarteapi.app.musician.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ListMusician.ListMusicianResponseDto;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ListMusicianService {
    
    @Autowired
    private IMusicianRepository musicianRepository;

    public ListMusicianService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    public ListMusicianResponseDto execute() throws Exception {
        try {

            List<Musician> musicians = musicianRepository.findAll();

            ListMusicianResponseDto response = new ListMusicianResponseDto(musicians);

            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
