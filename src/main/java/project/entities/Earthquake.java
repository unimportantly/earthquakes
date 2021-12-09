package project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Earthquake {

    // tells the db that this is the ID
    @Id
    private String id;
    private double magnitude;
    private Date date;
    private int deathToll;
    // link this document with the country doc
    @DBRef
    private Country location;

    public Earthquake() {
    }

    public Earthquake(String id, double magnitude, Date date, int deathToll, Country location) {
        this.id = id;
        this.magnitude = magnitude;
        this.date = date;
        this.deathToll = deathToll;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeathToll() {
        return deathToll;
    }

    public void setDeathToll(int deathToll) {
        this.deathToll = deathToll;
    }

    public Country getLocation() {
        return location;
    }

    public void setLocation(Country location) {
        this.location = location;
    }
}
