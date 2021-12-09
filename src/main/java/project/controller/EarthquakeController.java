package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.earthquake.EarthquakeDTO;
import project.dto.earthquake.EarthquakeDeleteDTO;
import project.dto.earthquake.EarthquakeSaveDTO;
import project.dto.earthquake.EarthquakeUpdateDTO;
import project.service.EarthquakeService;

import java.util.List;

@RestController
@RequestMapping("/earthquakes")
public class EarthquakeController {

    // get the singleton
    private EarthquakeService earthquakeService;

    // link it for spring through the controller
    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    // create

    /**
     * save a DTO in the db
     * @param earthquakeSaveDTO
     * @return a response including the saved DTO & a http status
     */
    @PostMapping
    public ResponseEntity<EarthquakeDTO> save(@RequestBody EarthquakeSaveDTO earthquakeSaveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(earthquakeService.save(earthquakeSaveDTO));
    }

    // read

    /**
     * find all the entries of this type in the database
     * @return a list of all entries in the db
     */
    @GetMapping
    public List<EarthquakeDTO> getEarthquakes(){
        return earthquakeService.findAll();
    }

    /**
     * find a single entity in the db
     * @param id the id of the entity we want to find
     * @return the entity found, mapped as a DTO if the search was fruitful, a not found error otherwise
     */
    @GetMapping("{id}")
    public ResponseEntity<EarthquakeDTO> getEarthquake(@PathVariable String id){
        EarthquakeDTO earthquakeDTO = earthquakeService.find(id);
        if(earthquakeDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(earthquakeDTO);
    }

    // update
    /**
     * update an entity inside the db with new values
     * @param earthquakeUpdateDTO the DTO that'll update the values
     * @return the updated object, in a responseEntity
     */
    @PutMapping()
    public ResponseEntity<EarthquakeDTO> update(@RequestBody EarthquakeUpdateDTO earthquakeUpdateDTO){
        return ResponseEntity.ok(earthquakeService.update(earthquakeUpdateDTO));
    }

    // delete
    /**
     * delete an entity from the db
     * @param earthquakeDeleteDTO the entity to delete
     * @return ResponseEntity : always an OK
     */
    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@RequestBody EarthquakeDeleteDTO earthquakeDeleteDTO){
        earthquakeService.delete(earthquakeDeleteDTO);
        return ResponseEntity.ok(true);
    }
}
