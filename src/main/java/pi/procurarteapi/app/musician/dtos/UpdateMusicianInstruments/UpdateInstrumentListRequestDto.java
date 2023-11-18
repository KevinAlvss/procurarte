package pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstrumentListRequestDto {
    private List<UpdateInstrumentRequestDto> instruments;
}
