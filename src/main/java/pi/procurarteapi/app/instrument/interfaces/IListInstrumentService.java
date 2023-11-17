package pi.procurarteapi.app.instrument.interfaces;

import pi.procurarteapi.app.instrument.dtos.ListInstrument.ListInstrumentResponseDto;

public interface IListInstrumentService {
    ListInstrumentResponseDto execute() throws Exception;
}
