package pi.procurarteapi.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.auth.dtos.LoginRequestDto;
import pi.procurarteapi.app.auth.dtos.LoginResponseDto;
import pi.procurarteapi.app.auth.services.LoginService;
import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianResponseDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.services.CreateMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;
import pi.procurarteapi.infra.repositories.IMusicianRepository;
import pi.procurarteapi.mockFactory.musician.MusicianFactory;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	private CreateMusicianService postMusicianService;

	@Autowired
	private ShowMusicianService showMusicianService;

	@Autowired
	private IMusicianRepository musicianRepository;

	@Autowired
	private LoginService loginService;

	private String okMusician = "OK";

	@Test
	void loginIsValid() throws Exception {

		MusicianDto musicianPost = MusicianFactory.MusicianGenerator(okMusician).generate();

		CreateMusicianResponseDto musicianResponse = postMusicianService
				.execute(new CreateMusicianRequestDto(musicianPost));

		LoginRequestDto loginRequest = new LoginRequestDto(musicianPost.getEmail(), musicianPost.getPassword());
		LoginResponseDto login = loginService.execute(loginRequest);

		ShowMusicianRequestDto request = new ShowMusicianRequestDto(login.getUserId());
		ShowMusicianResponseDto response = showMusicianService.execute(request);

		assertThat(musicianPost.getEmail().equals(response.getMusician().getEmail())).isTrue();
		assertThat(musicianPost.getName().equals(response.getMusician().getName())).isTrue();
		assertThat(musicianPost.getPhoneNumber().equals(response.getMusician().getPhoneNumber())).isTrue();

		musicianRepository.delete(musicianResponse.getMusician());
	}

	@Test
	void loginIsInvalid() throws Exception {

		LoginRequestDto loginRequest = new LoginRequestDto("InvalidEmail", "InvalidPassword");

		Throwable exception = assertThrows(Exception.class, () -> {
			loginService.execute(loginRequest);
		});

		assertThat(exception.getMessage()).isEqualTo("Login ou senha invalidos");

	}
}
