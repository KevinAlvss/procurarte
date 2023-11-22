package pi.procurarteapi.app.address.interfaces;

import pi.procurarteapi.app.address.dtos.GetAddress.GetAddressRequestDto;
import pi.procurarteapi.app.address.dtos.GetAddress.GetAddressResponseDto;

public interface IGetAddressService {
    GetAddressResponseDto execute(GetAddressRequestDto request) throws Exception;
}
