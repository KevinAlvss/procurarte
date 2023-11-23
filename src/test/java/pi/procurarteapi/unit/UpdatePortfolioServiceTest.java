package pi.procurarteapi.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.PortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioResponseDto;
import pi.procurarteapi.app.musician.services.PostMusicianService;
import pi.procurarteapi.app.musician.services.UpdatePortfolioService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Portfolio;
import pi.procurarteapi.infra.repositories.IMusicianRepository;
import pi.procurarteapi.mockFactory.musician.MusicianFactory;

@SpringBootTest
public class UpdatePortfolioServiceTest {

    @Autowired
    private UpdatePortfolioService updatePortfolioService;

    @Autowired
    private PostMusicianService postMusicianService;

    @Autowired
    private IMusicianRepository musicianRepository;

    private String okMusician = "OK";

    @Test
    void executeShouldThrowInstagramNotValidError() throws Exception {
        // Given
        Musician newMusician = MusicianFactory.MusicianGenerator(okMusician).generate();

        postMusicianService.execute(newMusician);

        UpdatePortfolioRequestDto request = new UpdatePortfolioRequestDto();
        PortfolioRequestDto portfolio = new PortfolioRequestDto();
        request.setId(newMusician.getId());

        portfolio.setInstagramProfile("invalid");
        request.setPortfolio(portfolio);

        // When
        Throwable exception = assertThrows(Exception.class, () -> {
            updatePortfolioService.execute(request);
        });

        // Then
        assertThat(exception.getMessage()).isEqualTo("Instagram Profile is not valid.");

        musicianRepository.delete(newMusician);
    }

    @Test
    void executeShouldSucceed() throws Exception {
        // Given
        Musician newMusician = MusicianFactory.MusicianGenerator(okMusician).generate();

        postMusicianService.execute(newMusician);

        UpdatePortfolioRequestDto request = new UpdatePortfolioRequestDto();
        PortfolioRequestDto portfolio = generatePortfolioRequestDto();
        request.setId(newMusician.getId());
        request.setPortfolio(portfolio);

        // When
        UpdatePortfolioResponseDto response = updatePortfolioService.execute(request);
        
        // Then
        Portfolio updatedPortfolio = response.getMusician().getPortfolio(); 
        
        assertThat(updatedPortfolio.getInstagramProfile()).isEqualTo(request.getPortfolio().getInstagramProfile());
        assertThat(updatedPortfolio.getMedia()).isEqualTo(request.getPortfolio().getMedia());
        assertThat(updatedPortfolio.getMusicianDescription()).isEqualTo(request.getPortfolio().getMusicianDescription());
        assertThat(updatedPortfolio.getProfilePhoto()).isEqualTo(request.getPortfolio().getProfilePhoto());
        assertThat(updatedPortfolio.getThumbnail()).isEqualTo(request.getPortfolio().getThumbnail());

        musicianRepository.delete(newMusician);
    }

    private PortfolioRequestDto generatePortfolioRequestDto(){
        PortfolioRequestDto portfolio = new PortfolioRequestDto();

        portfolio.setInstagramProfile("@validInstagramProfile");
        
        List<String> media = new ArrayList<>();
        media.add("image1");
        media.add("image2");
        media.add("image3");

        portfolio.setMedia(media);

        portfolio.setMusicianDescription("nice description");
        portfolio.setProfilePhoto("mine profile photo");
        portfolio.setThumbnail("mine thumbnail");

        return portfolio;
    }
}
