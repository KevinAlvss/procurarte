package pi.procurarteapi.app.musician.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            Instrument instrument = instrumentRepository.findByName(request.getInstrument().getName());

            if (instrument == null) {
                throw new Exception("Instrument not found");
            }

            addInstrumentInMusician(musician, instrument);

            Musician updatedMusician = musicianRepository.save(musician);

            UpdateMusicianInstrumentsResponseDto response = new UpdateMusicianInstrumentsResponseDto();
            response.setMusician(updatedMusician);
            
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void addInstrumentInMusician(Musician musician, Instrument instrument) throws Exception {
        List<Instrument> musicianInstruments = musician.getInstruments();

        if(musicianInstruments == null) {
            musician.setInstruments(new ArrayList<Instrument>());
        }

        musicianInstruments = musician.getInstruments();

        for(Instrument i: musicianInstruments){
            if(i.getId().equals(instrument.getId())){
                throw new Exception("Musician already has this instrument");
            }
        }

        musicianInstruments.add(instrument);
    }

}
