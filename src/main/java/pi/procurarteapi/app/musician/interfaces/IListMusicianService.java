package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.ListMusician.ListMusicianResponseDto;

public interface IListMusicianService {
    ListMusicianResponseDto execute() throws Exception;
}
