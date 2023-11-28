package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkResponseDto;
import pi.procurarteapi.app.musician.interfaces.IShowWhatsappLinkService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class ShowWhatsappLinkService implements IShowWhatsappLinkService{

    @Autowired
    private IMusicianRepository musicianRepository;

    private String whatsAppLinkBaseUrl = "https://wa.me/";

    @Override
    public ShowWhatsappLinkResponseDto execute(ShowWhatsappLinkRequestDto request) throws Exception {
        try {
            Musician musician = musicianRepository.findById(request.getId())
                    .orElseThrow(() -> new Exception("Musician Not Found"));

            if ((musician.getPhoneNumber() == null) || (musician.getPhoneNumber().trim() == "")){
                throw new Exception("Musician Phone Number is null, cannot redirect to WhatsApp");
            }

            String whatsappLink = whatsAppLinkBaseUrl + musician.getPhoneNumber();

            ShowWhatsappLinkResponseDto response = new ShowWhatsappLinkResponseDto();
            response.setLink(whatsappLink);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
