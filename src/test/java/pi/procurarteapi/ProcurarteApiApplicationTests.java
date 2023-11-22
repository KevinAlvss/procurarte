package pi.procurarteapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.services.PostMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Address;

@SpringBootTest
class ProcurarteApiApplicationTests {
	
	@Autowired
    private PostMusicianService postMusicianService;

	@Autowired
    private ShowMusicianService showMusicianService;

	@Test
	void musicianIsEqual() throws Exception {

		Address address = new Address("rua", "sp", "00000-000", "09", "null");
		Musician musicianPost = new Musician("idMock", "email@mock", "123", "Mock", "11999999999", "@moock", address, null, null, null);
	

		postMusicianService.execute(musicianPost);

		ShowMusicianRequestDto request = new ShowMusicianRequestDto("idMock"); 

		ShowMusicianResponseDto response = showMusicianService.execute(request); 

		assertThat(musicianPost == response.getMusician()).isTrue();
	}
}
