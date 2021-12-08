package project.repository;

import project.entities.Earthquake;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
}
