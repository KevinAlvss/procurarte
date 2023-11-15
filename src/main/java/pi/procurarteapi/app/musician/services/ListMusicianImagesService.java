package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesRequestDto;
import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesResponseDto;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ListMusicianImagesService {
    
    @Autowired
    private IMusicianRepository musicianRepository;

    public ListMusicianImagesService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    public ListMusicianImagesResponseDto execute(ListMusicianImagesRequestDto request) throws Exception {
        try {
            
            Musician musician = musicianRepository.findById(request.getId()).orElseThrow(() -> new Exception("Musician Not Found"));

            ListMusicianImagesResponseDto response = new ListMusicianImagesResponseDto();
            response.setImages(musician.getPortfolio().getMedia());
            response.setMusicianId(musician.getId());
            response.setThumbnail(musician.getPortfolio().getThumbnail());

            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
