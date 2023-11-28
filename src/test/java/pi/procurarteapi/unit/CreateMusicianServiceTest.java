package pi.procurarteapi.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianRequestDto;
import pi.procurarteapi.app.musician.services.CreateMusicianService;
import pi.procurarteapi.mockFactory.musician.MusicianFactory;

@SpringBootTest
public class CreateMusicianServiceTest {
    @Autowired
    private CreateMusicianService postMusicianService;

    private String okMusician = "OK";

    @Test
    void executeShouldThrowEmailNotValidError() throws Exception {
        // Given
        MusicianDto newMusician = MusicianFactory.MusicianGenerator(okMusician).generate();
        newMusician.setEmail("invalidEmail");

        // When
        Throwable exception = assertThrows(Exception.class, () -> {
            postMusicianService.execute(new CreateMusicianRequestDto(newMusician));
        });

        // Then
        assertThat(exception.getMessage()).isEqualTo("Email not valid");

    }

    @Test
    void executeShouldThrowCpfNotValidError() throws Exception {
        // Given
        MusicianDto newMusician = MusicianFactory.MusicianGenerator(okMusician).generate();
        newMusician.setCpf("invalidCpf");

        // When
        Throwable exception = assertThrows(Exception.class, () -> {
            postMusicianService.execute(new CreateMusicianRequestDto(newMusician));
        });

        // Then
        assertThat(exception.getMessage()).isEqualTo("Cpf not valid");
    }
}
