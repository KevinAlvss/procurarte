package pi.procurarteapi.app.musician.interfaces;

import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkResponseDto;

public interface IShowWhatsappLinkService {
    ShowWhatsappLinkResponseDto execute(ShowWhatsappLinkRequestDto request) throws Exception;
}
