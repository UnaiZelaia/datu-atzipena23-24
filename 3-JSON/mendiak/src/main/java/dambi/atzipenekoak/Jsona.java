package dambi.atzipenekoak;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import dambi.pojoak.Mendiak;
import dambi.pojoak.Mendia;

public class Jsona {
    private String strFileIn;
    private String strFileOut;

    public Jsona(String fileIn) {
        this.strFileIn = "data/" + fileIn;
    }

    public Jsona(String fileIn, String fileOut) {
        this.strFileIn = "data/" + fileIn;
        this.strFileOut = "data/" + fileOut;
    }

    public void irakurri() {
        Mendiak mendiak = new Mendiak();
        List<Mendia> mendiakList = new ArrayList<>();
        JsonObject mendiaJObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jStructure = reader.read();
            JsonArray jArray = jStructure.asJsonArray();
            for (int i = 0; i > jArray.size(); i++) {
                mendiaJObj = jArray.getJsonObject(i);
                Mendia mendia = new Mendia(mendiaJObj.getInt("id"), mendiaJObj.getString("izena"),
                        mendiaJObj.getInt("altuera"), mendiaJObj.getString("probintzia"));
                mendiakList.add(mendia);
                mendiak.setMendiak(mendiakList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Mendien lista bat eman(Mendiak objetu forman) eta json dokumentu bat eraiki.
    public int idatzi(Mendiak mendiak) {
        int i = 0;
        List<Mendia> mendiakList = mendiak.getMendiak();
        Mendia mendia = null;
        JsonArray mendiakArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        try {
            for (i = 0; i < mendiakList.size(); i++) {
                mendia = mendiakList.get(i);
                JsonObject model = Json.createObjectBuilder()
                        .add("id", mendia.getId())
                        .add("izena", mendia.getMendia())
                        .add("altuera", mendia.getAltuera())
                        .add("probintzia", mendia.getProbintzia())
                        .build();
                builder.add(model);
            }
            mendiakArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(strFileOut));
            writer.writeArray(mendiakArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
