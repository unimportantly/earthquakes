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

    private EarthquakeService earthquakeService;

    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    // create
    @PostMapping
    public ResponseEntity<EarthquakeDTO> save(@RequestBody EarthquakeSaveDTO earthquakeSaveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(earthquakeService.save(earthquakeSaveDTO));
    }

    // read

    @GetMapping
    public List<EarthquakeDTO> getEarthquakes(){
        return earthquakeService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<EarthquakeDTO> getEarthquake(@PathVariable String id){
        EarthquakeDTO earthquakeDTO = earthquakeService.find(id);
        if(earthquakeDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(earthquakeDTO);
    }

    // update
    @PutMapping()
    public ResponseEntity<EarthquakeDTO> update(@RequestBody EarthquakeUpdateDTO earthquakeUpdateDTO){
        return ResponseEntity.ok(earthquakeService.update(earthquakeUpdateDTO));
    }

    // delete
    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@RequestBody EarthquakeDeleteDTO earthquakeDeleteDTO){
        earthquakeService.delete(earthquakeDeleteDTO);
        return ResponseEntity.ok(true);
    }
}
