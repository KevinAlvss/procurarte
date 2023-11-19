package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;

import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioResponseDto;
import pi.procurarteapi.app.musician.interfaces.IPostMusicianImagePortifolio;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Portfolio;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

public class PostMusicianImagePortifolio implements IPostMusicianImagePortifolio{
    
    @Autowired
    private IMusicianRepository musicianRepository;

    public PostMusicianImagePortifolio(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public PostImagesPortifolioResponseDto execute(PostImagesPortifolioRequestDto request) throws Exception {
        
        try {
                Musician musician = musicianRepository.findById(request.getId())
                .orElseThrow(() -> new Exception("Musician Not Found"));

                Portfolio portfolio =  musician.getPortfolio();
                portfolio.setMedia(request.getImages());
                musician.setPortfolio(portfolio);

                Musician savedMusician = musicianRepository.save(musician);
                
                PostImagesPortifolioResponseDto response = new PostImagesPortifolioResponseDto();
                response.setMusician(savedMusician);

                
                return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
