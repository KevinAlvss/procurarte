package pi.procurarteapi.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.services.PostMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.mockFactory.musician.MusicianFactory;

@SpringBootTest
class ShowMusicianServiceTest {
	
	@Autowired
    private PostMusicianService postMusicianService;

	@Autowired
    private ShowMusicianService showMusicianService;

	private String okMusician = "OK";

	@Test
	void musicianIsEqual() throws Exception {

		Musician musicianPost = MusicianFactory.MusicianGenerator(okMusician).generate();

		postMusicianService.execute(musicianPost);

		ShowMusicianRequestDto request = new ShowMusicianRequestDto(musicianPost.getId()); 

		ShowMusicianResponseDto response = showMusicianService.execute(request); 

		assertThat(musicianPost.getId().equals(response.getMusician().getId())).isTrue();
		assertThat(musicianPost.getEmail().equals(response.getMusician().getEmail())).isTrue();
		assertThat(musicianPost.getName().equals(response.getMusician().getName())).isTrue();
		assertThat(musicianPost.getPhoneNumber().equals(response.getMusician().getPhoneNumber())).isTrue();
	}
}
