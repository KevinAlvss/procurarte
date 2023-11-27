package pi.procurarteapi.app.auth.services;

import org.springframework.stereotype.Service;

import pi.procurarteapi.app.auth.dtos.LoginRequestDto;
import pi.procurarteapi.app.auth.dtos.LoginResponseDto;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class LoginService {

    private IMusicianRepository musicianRepository;
    public LoginService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    public LoginResponseDto execute(LoginRequestDto request) throws Exception {
        try {
            Musician user = musicianRepository.findByEmail(request.getEmail());

            LoginResponseDto response = new LoginResponseDto(user.getEmail(), user.getPassword(), user.getId(), "token",
                    true);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
