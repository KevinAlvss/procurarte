package pi.procurarteapi.app.address.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponseDto {
    private String postalCode;
    private String street;
    private String complement;
    private String district;
    private String city;
    private String uf;
}
