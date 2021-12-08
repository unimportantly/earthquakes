package project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.country.CountryDTO;
import project.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // find & find all

    @GetMapping()
    public List<CountryDTO> getCountries() {
        return countryService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable String id){
        CountryDTO countryDTO = countryService.findById(id);
        if(countryDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(countryDTO);
    }
}
