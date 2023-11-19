package pi.procurarteapi.app.musicstyle.interfaces;

import pi.procurarteapi.app.musicstyle.dtos.ListMusicStyle.ListMusicStyleResponseDto;

public interface IListMusicStyleService {
    ListMusicStyleResponseDto execute() throws Exception;
}
