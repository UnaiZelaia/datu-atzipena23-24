package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonString;

public class JsonZuhaitzaSortuBi {
    public static void main(String[] args) {
        JsonObject model = Json.createObjectBuilder()
            .add("menu", Json.createObjectBuilder()
                .add("id", "file")
                .add("value", "File")
                .add("popup", Json.createObjectBuilder()
                    .add("menuItem", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                        .add("value", "New")
                        .add("onClick", "CreateNewDoc()"))
                    .add(Json.createObjectBuilder()
                        .add("value", "Open")
                        .add("onClick", "OPenDoc()"))
                    .add(Json.createObjectBuilder()
                        .add("value", "Close")
                        .add("onClick", "CloseDoc()"))
                        )
                    )
                )
            .build();

            
            try(JsonWriter writer = Json.createWriter(new FileOutputStream("data/irteera.json"))){
                writer.writeObject(model);
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
    }
}
