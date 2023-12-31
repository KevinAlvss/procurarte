package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.interfaces.IShowMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ShowMusicianService implements IShowMusicianService {

    @Autowired
    private IMusicianRepository musicianRepository;
    
    @Override
    public ShowMusicianResponseDto execute(ShowMusicianRequestDto request) throws Exception {
        try {

            Musician musician = musicianRepository.findById(request.getId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            ShowMusicianResponseDto response = new ShowMusicianResponseDto(musician);

            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
