package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;

import pi.procurarteapi.app.musician.dtos.PostImagesPortifolio.PostImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.interfaces.IPostMusicianImagePortifolio;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

public class PostMusicianImagePortifolio implements IPostMusicianImagePortifolio{
    
    @Autowired
    private IMusicianRepository musicianRepository;

    public PostMusicianImagePortifolio(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public PostMusicianImagePortifolio execute(PostImagesPortifolioRequestDto images) throws Exception {
        
        
        return null;
    }
}
