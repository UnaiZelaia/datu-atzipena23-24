package dambi.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;



@XmlType(propOrder = {"data", "ikaslea", "ikasgaia", "nota"})
@XmlRootElement(name = "Nota")
public class Nota {

    int id = 0;
    String ikaslea;
    LocalDate data;
    String ikasgaia;
    double nota;


    public Nota() {
    }


    public Nota(int id, String ikaslea, LocalDate data, String ikasgaia, double nota) {
        this.id = id;
        this.ikaslea = ikaslea;
        this.data = data;
        this.ikasgaia = ikasgaia;
        this.nota = nota;
    }


    @XmlAttribute(name = "id", required = true)
    public int getId(){
       return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Ikaslea")
    public String getIkaslea() {
        return ikaslea;
    }

    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }

    @XmlElement(name = "Data")
    public String getData() {
        return data.toString();
    }

    public void setData(String data) {
        this.data = LocalDate.parse(data);
    }

    @XmlElement(name = "Ikasgaia")
    public String getIkasgaia() {
        return ikasgaia;
    }

    public void setIkasgaia(String ikasgaia) {
        this.ikasgaia = ikasgaia;
    }
    
    @XmlElement(name = "Emaitza")
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota["+ id+", "+ikaslea+", "+data+", "+ikasgaia+", "+nota+"]";
    }
}
