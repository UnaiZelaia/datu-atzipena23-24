package dambi.unai.model;

import java.lang.reflect.GenericArrayType;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class Geolocation {

    private List<Double> coordinates;
    private String type;

    @JsonCreator
    public Geolocation() {
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
