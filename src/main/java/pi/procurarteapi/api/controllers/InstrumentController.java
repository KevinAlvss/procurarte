package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.instrument.dtos.ListInstrument.ListInstrumentResponseDto;
import pi.procurarteapi.app.instrument.services.ListInstrumentService;

@RestController
@CrossOrigin("*")
@Api(value = "Instrument")
@RequestMapping(value = "/instrument")
public class InstrumentController {

    @Autowired
    private ListInstrumentService listInstrumentService;

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        try {

            ListInstrumentResponseDto response = listInstrumentService.execute();

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
