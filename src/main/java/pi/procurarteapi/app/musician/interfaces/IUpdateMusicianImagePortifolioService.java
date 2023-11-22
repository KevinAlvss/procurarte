package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.UpdateImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.UpdateImagesPortifolioResponseDto;

public interface IUpdateMusicianImagePortifolioService {
    public UpdateImagesPortifolioResponseDto execute(UpdateImagesPortifolioRequestDto images)throws Exception;   
}
