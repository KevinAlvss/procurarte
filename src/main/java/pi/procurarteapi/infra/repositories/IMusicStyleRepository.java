package pi.procurarteapi.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pi.procurarteapi.infra.entities.Instrument;
import pi.procurarteapi.infra.entities.MusicStyle;

public interface IMusicStyleRepository extends MongoRepository<MusicStyle, String>{
    Instrument findByName(String name);
}
