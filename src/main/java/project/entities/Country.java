package project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Country {

    // tells the db that this is the id
    @Id
    private String id;
    private String name;
    private String code;
    // tells the db to link this doc with the earthquake doc through this attribute
    @DBRef
    private List<Earthquake> earthquakes;

    public Country() {
    }

    public Country(String id, String name, String code, List<Earthquake> earthquakes) {
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

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }
}
