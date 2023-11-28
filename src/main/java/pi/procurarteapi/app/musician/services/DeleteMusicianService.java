package pi.procurarteapi.app.musician.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.procurarteapi.app.musician.interfaces.IDeleteMusicianService;
import pi.procurarteapi.infra.repositories.IMusicianRepository;
import pi.procurarteapi.app.musician.dtos.DeleteMusician.DeleteMusicianRequestDto;
import pi.procurarteapi.app.musician.dtos.DeleteMusician.DeleteMusicianResponseDto;

@Service
public class DeleteMusicianService implements IDeleteMusicianService {

    @Autowired
    private IMusicianRepository musicianRepository;

    @Override
    public DeleteMusicianResponseDto execute(DeleteMusicianRequestDto request) throws Exception {
        try{

              musicianRepository.deleteById(request.getId());
              
              return new DeleteMusicianResponseDto(true);

        }catch (Exception e) { 
            throw new Exception(e.getMessage());
        } 
    }

}
