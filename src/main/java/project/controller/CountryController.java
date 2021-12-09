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

    // grab the singleton
    private CountryService countryService;

    // store it inside the controller
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // save

    /**
     * save a DTO in the db
     * @param countrySaveDTO
     * @return a response including the saved DTO & a http status
     */
    @PostMapping()
    public ResponseEntity<CountryDTO> save(@RequestBody CountrySaveDTO countrySaveDTO){
     return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(countrySaveDTO));
    }

    // find & find all

    /**
     * find all the entries of this type in the database
     * @return a list of all entries in the db
     */
    @GetMapping()
    public List<CountryDTO> getCountries() {
        return countryService.findAll();
    }

    /**
     * find a single entity in the db
     * @param id the id of the entity we want to find
     * @return the entity found, mapped as a DTO if the search was fruitful, a not found error otherwise
     */
    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable String id){
        CountryDTO countryDTO = countryService.find(id);
        if(countryDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(countryDTO);
    }

    // update

    /**
     * update an entity inside the db with new values
     * @param countryUpdateDTO the DTO that'll update the values
     * @return the updated object, in a responseEntity
     */
    @PutMapping()
    public ResponseEntity<CountryDTO> update(@RequestBody CountryUpdateDTO countryUpdateDTO){
        return ResponseEntity.ok(countryService.update(countryUpdateDTO));
    }

    // delete

    /**
     * delete an entity from the db
     * @param countryDeleteDTO the entity to delete
     * @return ResponseEntity : always an OK
     */
    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@RequestBody CountryDeleteDTO countryDeleteDTO){
        countryService.delete(countryDeleteDTO);
        return ResponseEntity.ok().build();
    }
}
