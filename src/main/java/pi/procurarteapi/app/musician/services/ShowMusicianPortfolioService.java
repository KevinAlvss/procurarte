package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioResponseDto;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ShowMusicianPortfolioService {
        
    @Autowired
    private IMusicianRepository musicianRepository;

    public ShowMusicianPortfolioService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    public ShowMusicianPortfolioResponseDto execute(ShowMusicianPortfolioRequestDto request) throws Exception {
        try {

            Musician musician = musicianRepository.findById(request.getId()).orElseThrow(() -> new Exception("Musician Not Found"));

            ShowMusicianPortfolioResponseDto response = new ShowMusicianPortfolioResponseDto();
            response.setMusicianId(musician.getId());
            response.setPortfolio(musician.getPortfolio());

            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
