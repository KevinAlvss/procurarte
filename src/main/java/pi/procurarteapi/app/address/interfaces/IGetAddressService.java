package pi.procurarteapi.app.address.interfaces;

import pi.procurarteapi.app.address.dtos.GetAddressResponseDto;

public interface IGetAddressService {
    GetAddressResponseDto execute(String cep) throws Exception;
}
