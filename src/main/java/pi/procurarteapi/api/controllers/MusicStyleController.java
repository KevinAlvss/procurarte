package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.musicstyle.dtos.ListMusicStyle.ListMusicStyleResponseDto;
import pi.procurarteapi.app.musicstyle.services.ListMusicStyleService;

@RestController
@CrossOrigin("*")
@Api(value = "MusicStyle")
@RequestMapping(value = "/musicstyle")
public class MusicStyleController {

    @Autowired
    private ListMusicStyleService listMusicStyleService;

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        try {

            ListMusicStyleResponseDto response = listMusicStyleService.execute();

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
