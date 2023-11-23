package pi.procurarteapi.infra.integrations.viacep.services;

import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pi.procurarteapi.infra.integrations.viacep.dtos.GetAddress.ViaCepGetAddressResponseDto;

@Service
public class ViaCepGetAddressService {
    private String baseUrlViaCep = "https://viacep.com.br/ws/";
    private String responseFormat = "json";

    public ViaCepGetAddressResponseDto getAddress(String cep) throws Exception {
        String url = baseUrlViaCep + cep + "/" + responseFormat;

        RestTemplate request = new RestTemplate();
        ResponseEntity<?> address = request.getForEntity(url, ViaCepGetAddressResponseDto.class);

        if (address.getStatusCode() == HttpStatus.OK) {
            return (ViaCepGetAddressResponseDto) address.getBody();
        }

        if (address.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new Exception("Invalid Cep.");
        }

        throw new Exception("Failed to get address.");
    }
}
