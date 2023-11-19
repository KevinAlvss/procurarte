package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioResponseDto;

public interface IPostMusicianImagePortifolio {
    public PostImagesPortifolioResponseDto execute(PostImagesPortifolioRequestDto images)throws Exception;   
}
