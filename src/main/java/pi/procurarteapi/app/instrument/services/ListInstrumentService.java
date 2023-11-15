package pi.procurarteapi.app.instrument.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.instrument.dtos.ListInstrument.ListInstrumentResponseDto;
import pi.procurarteapi.app.instrument.interfaces.IListInstrumentService;
import pi.procurarteapi.infra.entities.Instrument;
import pi.procurarteapi.infra.repositories.IInstrumentRepository;

@Service
public class ListInstrumentService implements IListInstrumentService {

    @Autowired
    private IInstrumentRepository instrumentRepository;

    public ListInstrumentService(IInstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public ListInstrumentResponseDto execute() throws Exception {
        try {

            List<Instrument> instruments = instrumentRepository.findAll();

            ListInstrumentResponseDto response = new ListInstrumentResponseDto(instruments);

            return response;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
