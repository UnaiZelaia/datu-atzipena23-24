package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"izena", "altuera", "probintzia"})
@XmlRootElement(name = "Country")
public class Mendia {
    private int id;
    private String mendia;
    private int altuera;
    private String probintzia;

    public Mendia(int id, String mendia, int altuera, String probintzia) {
        this.id = id;
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    public String getMendia() {
        return mendia;
    }
    public int getAltuera() {
        return altuera;
    }
    public String getProbintzia() {
        return probintzia;
    }

    //Setters
    @XmlAttribute(name = "id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "izena")
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    @XmlElement(name = "altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    @XmlElement(name = "probintzia")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    } 
}
