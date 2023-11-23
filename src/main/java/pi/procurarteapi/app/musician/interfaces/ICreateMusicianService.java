package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianResponseDto;

public interface ICreateMusicianService {
        public CreateMusicianResponseDto execute(CreateMusicianRequestDto musician) throws Exception;
}
