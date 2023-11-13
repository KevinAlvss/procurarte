package pi.procurarteapi.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pi.procurarteapi.infra.entities.Musician;

public interface IMusicianRepository extends MongoRepository<Musician, String> {
    
    Musician findByEmail(String email);
}
