package pi.procurarteapi.app.musicstyle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musicstyle.dtos.ListMusicStyle.ListMusicStyleResponseDto;
import pi.procurarteapi.app.musicstyle.interfaces.IListMusicStyleService;
import pi.procurarteapi.infra.entities.MusicStyle;
import pi.procurarteapi.infra.repositories.IMusicStyleRepository;

@Service
public class ListMusicStyleService implements IListMusicStyleService {

    @Autowired
    private IMusicStyleRepository musicStyleRepository;

    public ListMusicStyleService(IMusicStyleRepository musicStyleRepository) {
        this.musicStyleRepository = musicStyleRepository;
    }

    @Override
    public ListMusicStyleResponseDto execute() throws Exception {
        try {
            
            List<MusicStyle> musicStyles = musicStyleRepository.findAll();

            ListMusicStyleResponseDto response = new ListMusicStyleResponseDto(musicStyles);

            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
