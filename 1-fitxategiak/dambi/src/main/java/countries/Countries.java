package countries;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
    @XmlRootElement( name = "Countries" )
public class Countries
{
List countries;

/**
* element that is going to be marshaled in the xml
*/

@XmlElement( name = "Country" )
public void setCountries( List countries )
{
    this.countries = countries;
}

}
