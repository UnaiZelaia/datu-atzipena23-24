package countries;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Countries")
@XmlSeeAlso({Country.class})
public class Countries {

    
    List<Country> countries;

    /**
     * element that is going to be marshaled in the xml
     */

    public List getCountries(){
        return countries;
    } 

    @XmlElement(name = "Country")
    public void setCountries(List countries) {
        this.countries = countries;
    }
}
