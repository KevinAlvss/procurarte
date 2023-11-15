package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioResponseDto;
import pi.procurarteapi.app.musician.interfaces.IUpdatePortfolioService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Portfolio;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class UpdatePortfolioService implements IUpdatePortfolioService {

    @Autowired
    private IMusicianRepository musicianRepository;

    public UpdatePortfolioService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public UpdatePortfolioResponseDto execute(UpdatePortfolioRequestDto request) throws Exception {
        try {
            Musician musician = musicianRepository.findById(request.getId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            Portfolio newPortfolio = new Portfolio();
            newPortfolio.setMedia(request.getPortfolio().getMedia());
            newPortfolio.setMusicianDescription(request.getPortfolio().getMusicianDescription());
            newPortfolio.setProfilePhoto(request.getPortfolio().getProfilePhoto());
            newPortfolio.setThumbnail(request.getPortfolio().getThumbnail());

            musician.setPortfolio(newPortfolio);

            Musician savedMusician = musicianRepository.save(musician);

            UpdatePortfolioResponseDto response = new UpdatePortfolioResponseDto();
            response.setMusician(savedMusician);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
