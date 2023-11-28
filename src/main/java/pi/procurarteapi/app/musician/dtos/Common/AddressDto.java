package pi.procurarteapi.app.musician.dtos.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String street;
    private String state;
    private String postalCode;
    private String number;
    private String complement;
}
