package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsResponseDto;

public interface IUpdateMusicianInstrumentsService {
    UpdateMusicianInstrumentsResponseDto execute(UpdateMusicianInstrumentsRequestDto request) throws Exception;
}
