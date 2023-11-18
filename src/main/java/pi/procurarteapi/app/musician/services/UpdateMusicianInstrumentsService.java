package pi.procurarteapi.app.musician.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateInstrumentRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsResponseDto;
import pi.procurarteapi.app.musician.interfaces.IUpdateMusicianInstrumentsService;
import pi.procurarteapi.infra.entities.Instrument;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IInstrumentRepository;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class UpdateMusicianInstrumentsService implements IUpdateMusicianInstrumentsService {
    
    @Autowired
    private IMusicianRepository musicianRepository;

    @Autowired
    private IInstrumentRepository instrumentRepository;

    public UpdateMusicianInstrumentsService(IMusicianRepository musicianRepository,
            IInstrumentRepository instrumentRepository) {
        this.musicianRepository = musicianRepository;
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public UpdateMusicianInstrumentsResponseDto execute(UpdateMusicianInstrumentsRequestDto request) throws Exception {
        try {

            Musician musician = musicianRepository.findById(request.getMusicianId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            List<Instrument> instruments = validateInstruments(request.getInstrumentList().getInstruments());

            musician.setInstruments(instruments);

            Musician updatedMusician = musicianRepository.save(musician);

            UpdateMusicianInstrumentsResponseDto response = new UpdateMusicianInstrumentsResponseDto();
            response.setMusician(updatedMusician);
            
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private List<Instrument> validateInstruments(List<UpdateInstrumentRequestDto> instruments) throws Exception {
        List<Instrument> response = new ArrayList<>();
        
        for(UpdateInstrumentRequestDto instrument: instruments){
            
            Instrument databaseInstrument = instrumentRepository.findByName(instrument.getName());
            
            if (databaseInstrument == null) {
                throw new Exception("Instrument not found");
            }

            if (response.contains(databaseInstrument)){
                continue;
            }

            response.add(databaseInstrument);
        }

        return response;
    }

}
