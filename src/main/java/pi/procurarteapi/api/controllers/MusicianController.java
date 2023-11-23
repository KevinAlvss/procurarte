package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.ImagesRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio.UpdateImagesPortifolioResponseDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateInstrumentListRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianInstruments.UpdateMusicianInstrumentsResponseDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicStyleListRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdateMusicianMusicStyles.UpdateMusicianMusicStylesResponseDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.PortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioRequestDto;
import pi.procurarteapi.app.musician.dtos.UpdatePortfolio.UpdatePortfolioResponseDto;
import pi.procurarteapi.app.musician.services.ListMusicianImagesService;
import pi.procurarteapi.app.musician.services.ListMusicianService;
import pi.procurarteapi.app.musician.services.UpdateMusicianImagePortifolioService;
import pi.procurarteapi.app.musician.services.PostMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianPortfolioService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;
import pi.procurarteapi.app.musician.services.ShowWhatsappLinkService;
import pi.procurarteapi.app.musician.services.UpdateMusicianInstrumentsService;
import pi.procurarteapi.app.musician.services.UpdateMusicianMusicStylesServices;
import pi.procurarteapi.app.musician.services.UpdatePortfolioService;
import pi.procurarteapi.infra.entities.Musician;

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

    @Autowired
    private UpdateMusicianMusicStylesServices updateMusicianMusicStylesServices;

    @Autowired
    private UpdateMusicianImagePortifolioService updateMusicianImagePortifolioService;

    @Autowired
    private PostMusicianService postMusicianService;

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

    @PostMapping()
    public ResponseEntity<?> postMusician(@RequestBody Musician musician){ 
        try {
            
                Musician newMusician = postMusicianService.execute(musician);
                return ResponseEntity.status(HttpStatus.OK).body(newMusician);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("{id}/images")
       public ResponseEntity<?> updateImages(@PathVariable String id, @RequestBody ImagesRequestDto images) throws Exception {
        try {
            
            UpdateImagesPortifolioResponseDto response = updateMusicianImagePortifolioService.execute(new UpdateImagesPortifolioRequestDto(id, images));
            
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }catch(Exception e){
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

    @PatchMapping("{id}/portfolio")
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

    @PatchMapping("{id}/instrument")
    public ResponseEntity<?> updateMusicianInstruments(@PathVariable String id, @RequestBody UpdateInstrumentListRequestDto instruments) throws Exception {
        try {
            
            UpdateMusicianInstrumentsResponseDto response = updateMusicianInstrumentsService.execute(new UpdateMusicianInstrumentsRequestDto(id, instruments));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("{id}/musicstyle")
    public ResponseEntity<?> updateMusicianMusicStyles(@PathVariable String id, @RequestBody UpdateMusicStyleListRequestDto musicStyles) throws Exception {
        try {
            
            UpdateMusicianMusicStylesResponseDto response = updateMusicianMusicStylesServices.execute(new UpdateMusicianMusicStylesRequestDto(id, musicStyles));

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
