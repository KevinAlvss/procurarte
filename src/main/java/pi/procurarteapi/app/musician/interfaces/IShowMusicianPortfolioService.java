package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioResponseDto;

public interface IShowMusicianPortfolioService {
    ShowMusicianPortfolioResponseDto execute(ShowMusicianPortfolioRequestDto request) throws Exception;
}
