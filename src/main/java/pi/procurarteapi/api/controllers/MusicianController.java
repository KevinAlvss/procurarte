package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.musician.dtos.ListMusicianResponseDto;
import pi.procurarteapi.app.musician.services.ListMusicianService;

@RestController
@CrossOrigin("*")
@Api(value = "Musician")
@RequestMapping(value = "/musician")
public class MusicianController {

    @Autowired
    private ListMusicianService listMusicianService;

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        try {
            
            ListMusicianResponseDto response = listMusicianService.execute();

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
