package dambi;

import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

public class JsonFitxategiaIrakurri {

    public static void main(String[] args) {
        try{
            JsonReader reader = Json.createReader(new FileReader("menu.json"));
            JsonStructure jStruct = reader.read();


            JsonObject jObj = jStruct.asJsonObject();
            //JsonArray jArray = jStruct.asJsonArray();
            System.out.println(jObj);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
