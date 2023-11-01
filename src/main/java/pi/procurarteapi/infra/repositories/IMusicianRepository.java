package pi.procurarteapi.infra.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pi.procurarteapi.infra.entities.Musician;

public interface IMusicianRepository extends MongoRepository<Musician, String> {
    
    Musician findByEmail(String email);

    List<Musician> findAll();
}
