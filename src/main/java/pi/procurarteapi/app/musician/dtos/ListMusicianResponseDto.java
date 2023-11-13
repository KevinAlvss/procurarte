package pi.procurarteapi.app.musician.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.infra.entities.Musician;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListMusicianResponseDto {
    private List<Musician> musicians;
}
