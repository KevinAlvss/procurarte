package pi.procurarteapi.app.musician.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicStyleRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesResponseDto;
import pi.procurarteapi.app.musician.interfaces.IUpdateMusicianMusicStylesServices;
import pi.procurarteapi.infra.entities.MusicStyle;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicStyleRepository;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class UpdateMusicianMusicStylesServices implements IUpdateMusicianMusicStylesServices {

    @Autowired
    private IMusicianRepository musicianRepository;

    @Autowired
    private IMusicStyleRepository musicStyleRepository;

    public UpdateMusicianMusicStylesServices(IMusicianRepository musicianRepository,
            IMusicStyleRepository musicStyleRepository) {
        this.musicianRepository = musicianRepository;
        this.musicStyleRepository = musicStyleRepository;
    }

    @Override
    public UpdateMusicianMusicStylesResponseDto execute(UpdateMusicianMusicStylesRequestDto request) throws Exception {
        try {
            
            Musician musician = musicianRepository.findById(request.getMusicianId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            List<MusicStyle> musicStyles = validateMusicStyles(request.getMusicStyleList().getMusicStyles());
            
            musician.setMusicStyles(musicStyles);

            Musician updatedMusician = musicianRepository.save(musician);

            UpdateMusicianMusicStylesResponseDto response = new UpdateMusicianMusicStylesResponseDto();
            response.setMusician(updatedMusician);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private List<MusicStyle> validateMusicStyles(List<UpdateMusicStyleRequestDto> musicStyles) throws Exception {
        List<MusicStyle> response = new ArrayList<>();

        for(UpdateMusicStyleRequestDto musicStyle: musicStyles){

            MusicStyle databaseMusicStyle = musicStyleRepository.findByName(musicStyle.getName());

            if (databaseMusicStyle == null) {
                throw new Exception("Music Style not found");
            }

            if (response.contains(databaseMusicStyle)){
                continue;
            }

            response.add(databaseMusicStyle);
        }

        return response;
    }
    
}
