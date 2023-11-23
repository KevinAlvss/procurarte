package pi.procurarteapi.app.musician.dtos.CreateMusician;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMusicianRequestDto {
    private MusicianDto musician;
}
