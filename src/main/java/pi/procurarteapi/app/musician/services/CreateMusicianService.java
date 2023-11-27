 package pi.procurarteapi.app.musician.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.common.RegexPatterns;
import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.CreateMusician.CreateMusicianResponseDto;
import pi.procurarteapi.app.musician.interfaces.ICreateMusicianService;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Address;
import pi.procurarteapi.infra.entities.Musician.Portfolio;
import pi.procurarteapi.infra.repositories.IInstrumentRepository;
import pi.procurarteapi.infra.repositories.IMusicStyleRepository;
import pi.procurarteapi.infra.repositories.IMusicianRepository;

@Service
public class CreateMusicianService implements ICreateMusicianService {

    @Autowired
    private IMusicianRepository musicianRepository;

    @Autowired
    private IInstrumentRepository instrumentRepository;

    @Autowired
    private IMusicStyleRepository musicStyleRepository;

    private static final Pattern emailRegexPattern = Pattern.compile(RegexPatterns.EmailValidator);
    private static final Pattern cpfRegexPattern = Pattern.compile(RegexPatterns.CpfValidator);

    public CreateMusicianService(IMusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @Override
    public CreateMusicianResponseDto execute(CreateMusicianRequestDto request) throws Exception {
        try {
            Validate(request);

            Musician musicianToSave = MusicianDtoToMusician(request.getMusician());

            Musician savedMusician = musicianRepository.save(musicianToSave);

            CreateMusicianResponseDto response = new CreateMusicianResponseDto(savedMusician);

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void Validate(CreateMusicianRequestDto request) throws Exception {
        MusicianDto musician = request.getMusician();

        boolean isValidEmail = emailRegexPattern.matcher(musician.getEmail()).matches();
        boolean isValidCpf = cpfRegexPattern.matcher(musician.getCpf()).matches();

        if (!isValidEmail) {
            throw new Exception("Email not valid");
        }

        if (!isValidCpf) {
            throw new Exception("Cpf not valid");
        }
    }

    private Musician MusicianDtoToMusician(MusicianDto dto) {
        Portfolio portfolio = new Portfolio.Builder()
                .media(dto.getPortfolio().getMedia())
                .musicianDescription(dto.getPortfolio().getMusicianDescription())
                .profilePhoto(dto.getPortfolio().getProfilePhoto())
                .thumbnail(dto.getPortfolio().getThumbnail())
                .instagramProfile(dto.getPortfolio().getInstagramProfile())
                .build();

        Address address = new Address(dto.getAddress().getStreet(), dto.getAddress().getState(),
                dto.getAddress().getPostalCode(), dto.getAddress().getNumber(), dto.getAddress().getComplement());
        
        Musician musician = new Musician(dto.getEmail(), dto.getPassword(), dto.getName(), dto.getPhoneNumber(), dto.getCpf(),
                address, portfolio);

        PasswordEncoder passEncoder = new BCryptPasswordEncoder();
        String criptoPass = passEncoder.encode(musician.getPassword());
        musician.setPassword(criptoPass);

        return musician;
    }
}
