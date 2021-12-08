package project.dto.earthquake;

import project.entities.Country;

import java.util.Date;

public class EarthquakeSaveDTO {

    private double magnitude;
    private Date date;
    private int deathToll;
    private Country location;

    public EarthquakeSaveDTO() {
    }

    public EarthquakeSaveDTO(double magnitude, Date date, int deathToll, Country location) {
        this.magnitude = magnitude;
        this.date = date;
        this.deathToll = deathToll;
        this.location = location;
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
