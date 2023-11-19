package pi.procurarteapi.app.musicstyle.dtos.ListMusicStyle;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.infra.entities.MusicStyle;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListMusicStyleResponseDto {
    List<MusicStyle> musicStyles;
}
