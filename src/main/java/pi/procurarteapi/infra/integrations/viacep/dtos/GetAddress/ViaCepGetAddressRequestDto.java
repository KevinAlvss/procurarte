package pi.procurarteapi.infra.integrations.viacep.dtos.GetAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepGetAddressRequestDto {
    private String cep;
}
