package countries;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Countries")
@XmlSeeAlso({Country.class})
public class Countries {

    ArrayList<Country> countries;

    /**
     * element that is going to be marshaled in the xml
     */

    public ArrayList<Country> getCountries(){
        return countries;
    }

    @XmlElement(name = "Country")
    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
