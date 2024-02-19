package dambi.unai.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Id;

@Document(collection = "meteorites")
public class Impact {
    @Id
    private int impactId;

    private String fall;
    private Geolocation geolocation;
    private String mass;
    private String name;
    private String nametype;
    private String reclat;
    private String reclong;
    private String year;

    @JsonCreator
    public Impact() {
    }
    
    public int getImpactId() {
        return impactId;
    }
    public void setImpactId(int impactId) {
        this.impactId = impactId;
    }
    public String getFall() {
        return fall;
    }
    public void setFall(String fall) {
        this.fall = fall;
    }
    
    public String getMass() {
        return mass;
    }
    public void setMass(String mass) {
        this.mass = mass;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNametype() {
        return nametype;
    }
    public void setNametype(String nametype) {
        this.nametype = nametype;
    }
    public String getReclat() {
        return reclat;
    }
    public void setReclat(String reclat) {
        this.reclat = reclat;
    }
    public String getReclong() {
        return reclong;
    }
    public void setReclong(String reclong) {
        this.reclong = reclong;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Geolocation getGeolocation() {
        return geolocation;
    }
    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    
}
