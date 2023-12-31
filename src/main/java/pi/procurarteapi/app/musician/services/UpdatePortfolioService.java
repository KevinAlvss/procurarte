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

    @Override
    public UpdatePortfolioResponseDto execute(UpdatePortfolioRequestDto request) throws Exception {
        try {
            Validate(request);

            Musician musician = musicianRepository.findById(request.getId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            Portfolio newPortfolio = new Portfolio.Builder()
                    .media(request.getPortfolio().getMedia())
                    .musicianDescription(request.getPortfolio().getMusicianDescription())
                    .profilePhoto(request.getPortfolio().getProfilePhoto())
                    .thumbnail(request.getPortfolio().getThumbnail())
                    .instagramProfile(request.getPortfolio().getInstagramProfile())
                    .build();

            musician.setPortfolio(newPortfolio);

            Musician savedMusician = musicianRepository.save(musician);

            UpdatePortfolioResponseDto response = new UpdatePortfolioResponseDto();
            response.setMusician(savedMusician);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void Validate(UpdatePortfolioRequestDto request) throws Exception {
        if (!request.getPortfolio().getInstagramProfile().startsWith("@")) {
            throw new Exception("Instagram Profile is not valid.");
        }
    }

}
