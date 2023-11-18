package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.musician.dtos.ListMusician.ListMusicianResponseDto;
import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesRequestDto;
import pi.procurarteapi.app.musician.dtos.ListMusicianImages.ListMusicianImagesResponseDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusician.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianPortfolio.ShowMusicianPortfolioResponseDto;
import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowWhatsappLink.ShowWhatsappLinkResponseDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateInstrumentListRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsResponseDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.PortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioResponseDto;
import pi.procurarteapi.app.musician.services.ListMusicianImagesService;
import pi.procurarteapi.app.musician.services.ListMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianPortfolioService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;
import pi.procurarteapi.app.musician.services.ShowWhatsappLinkService;
import pi.procurarteapi.app.musician.services.UpdateMusicianInstrumentsService;
import pi.procurarteapi.app.musician.services.UpdatePortfolioService;

@RestController
@CrossOrigin("*")
@Api(value = "Musician")
@RequestMapping(value = "/musician")
public class MusicianController {

    @Autowired
    private ListMusicianService listMusicianService;

    @Autowired
    private ShowMusicianService showMusicianService;

    @Autowired
    private ListMusicianImagesService listMusicianImagesService;

    @Autowired
    private ShowMusicianPortfolioService showMusicianPortfolioService;

    @Autowired
    private UpdatePortfolioService updatePortfolioService;

    @Autowired
    private ShowWhatsappLinkService showWhatsappLinkService;

    @Autowired
    private UpdateMusicianInstrumentsService updateMusicianInstrumentsService;

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        try {
            
            ListMusicianResponseDto response = listMusicianService.execute();

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable String id) throws Exception {
        try {
            
            ShowMusicianResponseDto response = showMusicianService.execute(new ShowMusicianRequestDto(id));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("{id}/images")
    public ResponseEntity<?> listImages(@PathVariable String id) throws Exception {
        try {
            
            ListMusicianImagesResponseDto response = listMusicianImagesService.execute(new ListMusicianImagesRequestDto(id));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("{id}/portfolio")
    public ResponseEntity<?> showPortfolio(@PathVariable String id) throws Exception {
        try {
            
            ShowMusicianPortfolioResponseDto response = showMusicianPortfolioService.execute(new ShowMusicianPortfolioRequestDto(id));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("{id}/portfolio")
    public ResponseEntity<?> updatePortfolio(@PathVariable String id, @RequestBody PortfolioRequestDto portfolio) throws Exception {
        try {
            
            UpdatePortfolioResponseDto response = updatePortfolioService.execute(new UpdatePortfolioRequestDto(id, portfolio));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("{id}/whatsapp")
    public ResponseEntity<?> showWhatsappLink(@PathVariable String id) throws Exception {
        try {
            
            ShowWhatsappLinkResponseDto response = showWhatsappLinkService.execute(new ShowWhatsappLinkRequestDto(id));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("{id}/instrument")
    public ResponseEntity<?> updateMusicianInstruments(@PathVariable String id, @RequestBody UpdateInstrumentListRequestDto instrumentName) throws Exception {
        try {
            
            UpdateMusicianInstrumentsResponseDto response = updateMusicianInstrumentsService.execute(new UpdateMusicianInstrumentsRequestDto(id, instrumentName));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
