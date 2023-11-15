package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioResponseDto;

public interface IUpdatePortfolioService {
    UpdatePortfolioResponseDto execute(UpdatePortfolioRequestDto request) throws Exception;
}
