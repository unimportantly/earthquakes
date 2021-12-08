package project.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.country.CountryDTO;
import project.dto.country.CountryDeleteDTO;
import project.dto.country.CountrySaveDTO;
import project.dto.country.CountryUpdateDTO;
import project.entities.Country;
import project.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // save

    @PostMapping()
    public ResponseEntity<CountryDTO> save(@RequestBody CountrySaveDTO countrySaveDTO){
     return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(countrySaveDTO));
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

    // update

    @PutMapping()
    public ResponseEntity<CountryDTO> update(CountryUpdateDTO countryUpdateDTO){
        return ResponseEntity.ok(countryService.update(countryUpdateDTO));
    }

    // delete

    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@RequestBody CountryDeleteDTO countryDeleteDTO){
        countryService.delete(countryDeleteDTO);
        return ResponseEntity.ok().build();
    }
}
