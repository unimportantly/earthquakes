package project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UtilConfiguration {

    /**
     * stores a mapper object in the spring context to be accessed
     * from anywhere in the project
     * @return a modelmapper
     */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
