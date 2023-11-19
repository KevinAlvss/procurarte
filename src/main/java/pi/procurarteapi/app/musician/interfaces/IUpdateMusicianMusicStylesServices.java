package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesResponseDto;

public interface IUpdateMusicianMusicStylesServices {
    UpdateMusicianMusicStylesResponseDto execute(UpdateMusicianMusicStylesRequestDto request) throws Exception;
}
