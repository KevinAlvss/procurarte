package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioResponseDto;

public interface IUpdateMusicianImagePortifolioService {
    public UpdateImagesPortifolioResponseDto execute(UpdateImagesPortifolioRequestDto images)throws Exception;   
}
