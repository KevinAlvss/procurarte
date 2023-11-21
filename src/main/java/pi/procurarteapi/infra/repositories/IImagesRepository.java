package pi.procurarteapi.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pi.procurarteapi.infra.entities.Instrument;

public interface IImagesRepository extends MongoRepository<Instrument, String>{

    
}
