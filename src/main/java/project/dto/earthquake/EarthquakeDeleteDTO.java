package project.dto.earthquake;

import project.entities.Country;

import java.util.Date;

public class EarthquakeDeleteDTO {

    private String id;


    public EarthquakeDeleteDTO() {
    }

    public EarthquakeDeleteDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
