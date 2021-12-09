package project.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.repository.CountryRepository;
import project.service.CountryService;

@Configuration
public class CountryConfiguration {

    /**
     * creates a service bean in the spring context
     * @param countryRepository so that we can access the db
     * @param modelMapper so that we can change our DTOs classes
     * @return a CountryService instance
     */
    @Bean
    public CountryService countryService(CountryRepository countryRepository, ModelMapper modelMapper){
        return new CountryService(countryRepository, modelMapper);
    }
}
