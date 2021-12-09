package project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.repository.EarthquakeRepository;
import project.service.EarthquakeService;

@Configuration
public class EarthquakeConfiguration {

    /**
     * creates a service in the spring context to be accessed from anywhere
     * @param earthquakeRepository through which we can access the db
     * @param modelMapper so that we can modify our DTO's classes
     * @return a service instance
     */
    @Bean
    public EarthquakeService earthquakeService(EarthquakeRepository earthquakeRepository, ModelMapper modelMapper){
        return new EarthquakeService(earthquakeRepository, modelMapper);
    }
}
