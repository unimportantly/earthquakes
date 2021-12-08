package project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.repository.EarthquakeRepository;
import project.service.EarthquakeService;

@Configuration
public class EarthquakeConfiguration {

    @Bean
    public EarthquakeService earthquakeService(EarthquakeRepository earthquakeRepository, ModelMapper modelMapper){
        return new EarthquakeService(earthquakeRepository, modelMapper);
    }
}
