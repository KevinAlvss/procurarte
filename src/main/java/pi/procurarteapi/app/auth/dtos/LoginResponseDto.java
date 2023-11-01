package pi.procurarteapi.app.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String email;
    private String password;
    private String userId;
    private String token;
    private boolean isValid;
}
