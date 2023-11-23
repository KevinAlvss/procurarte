package pi.procurarteapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pi.procurarteapi.app.address.dtos.GetAddressResponseDto;
import pi.procurarteapi.app.address.services.GetAddressService;

@RestController
@CrossOrigin("*")
@Api(value = "Address")
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private GetAddressService adressService;
    
    @GetMapping("{cep}")
    public ResponseEntity<?> getAddress(@PathVariable String cep) throws Exception {
        try {
            
            GetAddressResponseDto response = adressService.execute(cep);

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
