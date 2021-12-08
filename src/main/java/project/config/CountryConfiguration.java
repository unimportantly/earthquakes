package project.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.repository.CountryRepository;
import project.service.CountryService;

@Configuration
public class CountryConfiguration {

    @Bean
    public CountryService countryService(CountryRepository countryRepository, ModelMapper modelMapper){
        return new CountryService(countryRepository, modelMapper);
    }
}
