package dambi.pojoak;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "mendiak")
@XmlSeeAlso({Mendia.class})
public class Mendiak {
    private List<Mendia> mendiak;

    @XmlElement(name = "mendia")
    public void setMendiak(List<Mendia> mendiak){
        this.mendiak = mendiak;
    }

    public List<Mendia> getMendiak() {
        return mendiak;
    }
}
