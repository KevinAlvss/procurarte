package pi.procurarteapi.app.address.services;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pi.procurarteapi.app.address.dtos.GetAddress.GetAddressRequestDto;
import pi.procurarteapi.app.address.dtos.GetAddress.GetAddressResponseDto;
import pi.procurarteapi.app.address.interfaces.IGetAddressService;


@Service
public class GetAddressService implements IGetAddressService{

    private String baseUrlViaCep = "https://viacep.com.br/ws/";
    private String responseFormat = "json";

    @Override
    public GetAddressResponseDto execute(GetAddressRequestDto request) throws Exception {
        
        if(request.getCep() == null || request.getCep().trim() == "" ) {
            throw new Exception("CEP does not informed.");
        }

        GetAddressResponseDto resp = getAddress(baseUrlViaCep + request.getCep() + "/" + responseFormat);

        return resp;
    }

    private GetAddressResponseDto getAddress (String url) throws Exception {
        RestTemplate request = new RestTemplate();
        ResponseEntity<?> address = request.getForEntity(url, GetAddressResponseDto.class);

        // TODO :: MELHORAR E FAZER FUNCIONAR VALIDAÇÕES

        // if(address.getStatusCode() != HttpStatus.OK) {
        //     throw new Exception("CEP does not exist.");
        // }

        // if(address.getBody() == null) {
        //     throw new Exception("CEP does not exist (2).");
        // }

        return (GetAddressResponseDto) address.getBody();
    }
    
}
