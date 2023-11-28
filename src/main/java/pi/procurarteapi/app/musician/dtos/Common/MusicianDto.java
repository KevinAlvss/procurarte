package pi.procurarteapi.app.musician.dtos.Common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicianDto {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String cpf;
    private AddressDto address;
    private PortfolioDto portfolio;
    private List<MusicStyleDto> musicStyles;
    private List<InstrumentDto> instruments;
}
