package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioResponseDto;
import pi.procurarteapi.app.musician.interfaces.IUpdateMusicianImagePortifolioService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Portfolio;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class UpdateMusicianImagePortifolioService implements IUpdateMusicianImagePortifolioService {

    @Autowired
    private IMusicianRepository musicianRepository;

    public UpdateMusicianImagePortifolioService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public UpdateImagesPortifolioResponseDto execute(UpdateImagesPortifolioRequestDto request) throws Exception {
        try {
            
            Musician musician = musicianRepository.findById(request.getId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            Portfolio portfolio = musician.getPortfolio();
            
            portfolio.setMedia(request.getImages().getImages());
            musician.setPortfolio(portfolio);

            Musician savedMusician = musicianRepository.save(musician);

            UpdateImagesPortifolioResponseDto response = new UpdateImagesPortifolioResponseDto();
            response.setMusician(savedMusician);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
