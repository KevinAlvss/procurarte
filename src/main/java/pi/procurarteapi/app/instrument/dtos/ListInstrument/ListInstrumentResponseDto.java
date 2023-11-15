package pi.procurarteapi.app.instrument.dtos.ListInstrument;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.infra.entities.Instrument;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListInstrumentResponseDto {
    List<Instrument> instrument;
}
