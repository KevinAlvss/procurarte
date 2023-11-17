package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;

public interface IShowMusicianService {
    ShowMusicianResponseDto execute(ShowMusicianRequestDto request) throws Exception;
}
