package project.dto.country;

import project.dto.earthquake.EarthquakeDTO;
import project.entities.Earthquake;

import java.util.List;

public class CountrySaveDTO {

    //why don't we need the list of earthquakes here?
    private String name;
    private String code;

    public CountrySaveDTO() {
    }

    public CountrySaveDTO(String name, String code) {
        this.name = name;
        this.code = code;
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

}
