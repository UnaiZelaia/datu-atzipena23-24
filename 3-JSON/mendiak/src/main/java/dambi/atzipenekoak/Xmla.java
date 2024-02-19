package dambi.atzipenekoak;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import dambi.pojoak.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    private String strFileIn;
    private String strFileOut;

    public Xmla(String fileIn){
        this.strFileIn = "data/" + fileIn;
    }

    public Xmla(String FileIn, String FileOut){
        this.strFileIn = "data/" +FileIn;
        this.strFileOut = "data/" +FileOut;
    }


    public Mendiak irakurri(){
        Mendiak mendiak = new Mendiak();

        try{
            File fileIn = new File(strFileIn);
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);

            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            mendiak = (Mendiak) jaxbUnmar.unmarshal(fileIn);

        } catch(Exception e){
            e.printStackTrace();
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak){
        try{

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(strFileOut);
            OutputStream os = new FileOutputStream(strFileOut);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mendiak, os);

        } catch(Exception e){
            e.printStackTrace();
        }
        return mendiak.getMendiak().size();
    }
}
