package pi.procurarteapi.api.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.musician.dtos.ListMusicianResponseDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.ShowMusicianResponseDto;
import pi.procurarteapi.app.musician.services.ListMusicianService;
import pi.procurarteapi.app.musician.services.ShowMusicianService;

@RestController
@CrossOrigin("*")
@Api(value = "Musician")
@RequestMapping(value = "/musician")
public class MusicianController {

    @Autowired
    private ListMusicianService listMusicianService;

    @Autowired
    private ShowMusicianService showMusicianService;

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

    @PostMapping("{id}/images")
       public ResponseEntity<?> postImages(@PathVariable String id, @RequestBody ArrayList<String> images) throws Exception {
        try {
            
            ArrayList<String> response; 

            //return ResponseEntity.status(HttpStatus.OK).body(response);
            return null;


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
