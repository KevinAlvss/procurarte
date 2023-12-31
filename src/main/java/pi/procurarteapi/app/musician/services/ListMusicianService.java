package pi.procurarteapi.app.musician.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ListMusician.ListMusicianResponseDto;
import pi.procurarteapi.app.musician.interfaces.IListMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ListMusicianService implements IListMusicianService {

    @Autowired
    private IMusicianRepository musicianRepository;

    @Override
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
