package countries;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "capital", "foundation", "continent", "population" })
@XmlRootElement(name = "Country")

public class Country {
    private int population;
    private String name;
    private String capital;
    private int importance;
    private LocalDate foundation;
    private String continent;

    @XmlElement(name = "Country_Population")
    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation(){
        return this.population;
    }

    @XmlElement(name = "Country_Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @XmlElement(name = "Country_Capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital(){
        return this.capital;
    }

    @XmlAttribute(name = "importance", required = true)
    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getImportance(){
        return this.importance;
    }

    @XmlElement(name = "Foundation")
    public void setFoundation(LocalDate foundation){
        this.foundation = foundation;
    }

    public LocalDate getFoundation(){
        return this.foundation;
    }

    @XmlElement(name = "Continent")
    public void setContinent(String continent){
        this.continent = continent;
    }
    public String getContinent(){
        return this.continent;
    }



}