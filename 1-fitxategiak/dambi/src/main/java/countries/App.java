package countries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;



public class App {
    public static void main(String[] args) {

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setContinent("Europe");
        spain.setImportance(1);
        spain.setFoundation(LocalDate.of(1469, 10, 19));
        spain.setPopulation(45000000);

        Country portugal = new Country();
        portugal.setName("Portugal");
        spain.setCapital("Madrid");
        spain.setContinent("Europe");
        spain.setImportance(1);
        spain.setFoundation(LocalDate.of(1469, 10, 19));
        spain.setPopulation(45000000);

        Countries list = new Countries();


        try {
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            new File("country.xml");
            OutputStream os = new FileOutputStream("country.xml");


            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(spain, os);
        } catch (JAXBException e) {
            System.out.println("Error: " + e.getMessage() + "Linked exceptions: " + e.getLinkedException());
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
