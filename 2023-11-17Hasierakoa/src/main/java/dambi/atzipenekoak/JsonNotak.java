package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class JsonNotak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonNotak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonNotak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

   
    public Notak irakurri() {
        Notak notak = new Notak();
        List<Nota> notakList = new ArrayList<>();
        JsonObject notakObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jStructure = reader.read();
            JsonArray jArray = jStructure.asJsonArray();
            for(int i = 0; i < jArray.size(); i++){
                notakObj = jArray.getJsonObject(i);
                String data = notakObj.getString("data");
                LocalDate dataDate = LocalDate.parse(data);
                JsonNumber number = notakObj.getJsonNumber("nota");
                double notaDouble = number.doubleValue();
                Nota nota = new Nota(notakObj.getInt("id"), notakObj.getString("ikaslea"), dataDate, notakObj.getString("ikasgaia"), notaDouble);
                notakList.add(nota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notak.setNotak(notakList);
        return notak;
    }






 /* 
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
        */
}
