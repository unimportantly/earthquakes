package project.dto.country;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import project.dto.earthquake.EarthquakeDTO;
import project.entities.Earthquake;

import java.util.List;

public class CountryDTO {

    private String id;
    private String name;
    private String code;
    private List<EarthquakeDTO> earthquakes;

    public CountryDTO() {
    }

    public CountryDTO(String id, String name, String code, List<EarthquakeDTO> earthquakes) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.earthquakes = earthquakes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EarthquakeDTO> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<EarthquakeDTO> earthquakes) {
        this.earthquakes = earthquakes;
    }
}
