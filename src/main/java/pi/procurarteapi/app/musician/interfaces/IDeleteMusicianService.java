package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.DeleteMusician.DeleteMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.DeleteMusician.DeleteMusicianResponseDto;

public interface IDeleteMusicianService {
    public DeleteMusicianResponseDto execute(DeleteMusicianRequestDto request)  throws Exception;
}
