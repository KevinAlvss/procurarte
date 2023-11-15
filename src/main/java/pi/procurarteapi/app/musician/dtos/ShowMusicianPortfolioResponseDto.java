package pi.procurarteapi.app.musician.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.procurarteapi.infra.entities.Musician.Portfolio;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShowMusicianPortfolioResponseDto {
    private String musicianId;
    private Portfolio portfolio;
}
