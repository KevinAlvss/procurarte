package pi.procurarteapi.app.address.services;

import org.springframework.stereotype.Service;

import pi.procurarteapi.app.address.dtos.GetAddressResponseDto;
import pi.procurarteapi.app.address.interfaces.IGetAddressService;
import pi.procurarteapi.infra.integrations.viacep.dtos.GetAddress.ViaCepGetAddressResponseDto;
import pi.procurarteapi.infra.integrations.viacep.services.ViaCepGetAddressService;

@Service
public class GetAddressService implements IGetAddressService {

    private ViaCepGetAddressService getAddressService;

    public GetAddressService(ViaCepGetAddressService getAddressService) {
        this.getAddressService = getAddressService;
    }

    @Override
    public GetAddressResponseDto execute(String cep) throws Exception {
        Validate(cep);

        ViaCepGetAddressResponseDto viaCepResponse = getAddressService.getAddress(cep);
        GetAddressResponseDto response = ViaCepToGetAddressResponseDto(viaCepResponse);

        return response;
    }

    private void Validate(String request) throws Exception {
        if (request == null || request.trim().equals("")) {
            throw new Exception("CEP not informed.");
        }
    }

    private GetAddressResponseDto ViaCepToGetAddressResponseDto(ViaCepGetAddressResponseDto source) {
        GetAddressResponseDto response = new GetAddressResponseDto();
        
        response.setCity(source.getLocalidade());
        response.setComplement(source.getComplemento());
        response.setPostalCode(source.getCep());
        response.setStreet(source.getLogradouro());
        response.setUf(source.getUf());
        response.setDistrict(source.getBairro());

        return response;
    }

}
