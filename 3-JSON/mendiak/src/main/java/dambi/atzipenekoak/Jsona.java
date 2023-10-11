package dambi.atzipenekoak;

import java.io.FileReader;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonStructure;
import jakarta.json.stream.JsonParser;
import dambi.pojoak.Mendiak;

public class Jsona {
    private String strFileIn;
    private String strFileOut;

    public Jsona(String fileIn){
        this.strFileIn = fileIn;
    }

    public Jsona(String fileIn, String fileOut){
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    //TODO convert our JSON array into Mendiak java object
    public Mendiak irakurri(){
        Mendiak mendiak = new Mendiak();
        try{
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jStructure = reader.read();

            JsonArray jArray = jStructure.asJsonArray();



        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
