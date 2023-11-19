package pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.infra.entities.Musician;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMusicianInstrumentsResponseDto {
    private Musician musician;
}
