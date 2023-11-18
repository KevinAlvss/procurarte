package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.services.PostMusicianImagePortifolio;

public interface IPostMusicianImagePortifolio {
    public PostMusicianImagePortifolio execute(PostImagesPortifolioRequestDto images)throws Exception;   
}
