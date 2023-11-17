package pi.procurarteapi.app.musician.dtos.UpdatePortfolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePortfolioRequestDto {
    private String id;
    private PortfolioRequestDto portfolio;
}