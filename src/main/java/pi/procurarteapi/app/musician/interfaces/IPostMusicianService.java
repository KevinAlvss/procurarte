package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.infra.entities.Musician;

public interface IPostMusicianService {
        public Musician execute(Musician musician)throws Exception;   
}
