package pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMusicStyleListRequestDto {
    private List<UpdateMusicStyleRequestDto> musicStyles;
}
