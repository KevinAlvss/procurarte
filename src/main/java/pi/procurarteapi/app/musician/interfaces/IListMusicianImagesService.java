package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesRequestDto;
import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesResponseDto;

public interface IListMusicianImagesService {
    ListMusicianImagesResponseDto execute(ListMusicianImagesRequestDto request) throws Exception;
}
