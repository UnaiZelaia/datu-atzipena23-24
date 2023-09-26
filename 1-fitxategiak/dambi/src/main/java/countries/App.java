package countries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;



public class App {
    public static void main(String[] args) {


        Countries countriesList = new Countries();
        ArrayList<Country> list = new ArrayList<Country>();
        



        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setContinent("Europe");
        spain.setImportance(1);
        spain.setFoundation(LocalDate.of(1469, 10, 19));
        spain.setPopulation(45000000);

        Country portugal = new Country();
        portugal.setName("Portugal");
        portugal.setCapital("Lisboa");
        portugal.setContinent("Europe");
        portugal.setImportance(1);
        portugal.setFoundation(LocalDate.of(1139, 10, 19));
        portugal.setPopulation(10000000);

        list.add(portugal);
        list.add(spain);

        countriesList.setCountries(list);

        try {
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            new File("country.xml");
            OutputStream os = new FileOutputStream("country.xml");

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(countriesList, os);
        } catch (JAXBException e) {
            System.out.println("Error: " + e.getMessage() + "\nLinked exceptions: " + e.getLinkedException());
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
