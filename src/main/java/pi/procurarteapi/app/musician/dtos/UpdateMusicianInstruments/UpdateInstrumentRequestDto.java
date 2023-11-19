package pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstrumentRequestDto {
    private String name;
}
