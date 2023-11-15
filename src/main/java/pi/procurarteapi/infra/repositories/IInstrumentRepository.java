package pi.procurarteapi.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pi.procurarteapi.infra.entities.Instrument;

public interface IInstrumentRepository extends MongoRepository<Instrument, String> { }
