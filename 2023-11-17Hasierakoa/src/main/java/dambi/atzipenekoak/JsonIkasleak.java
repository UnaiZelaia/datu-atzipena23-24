package dambi.atzipenekoak;

import java.io.FileNotFoundException;
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

import dambi.pojoak.Ikaslea;
import dambi.pojoak.Ikasleak;
import dambi.pojoak.Notak;


public class JsonIkasleak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonIkasleak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonIkasleak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public int idatzi(Ikasleak ikasleak) {
        List<Ikaslea> ikasleLista = ikasleak.getIkasleak();
        JsonArray ikasleJsonArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        try {
            for(int i = 0; i < ikasleLista.size(); i++){
                Ikaslea ikaslea = ikasleLista.get(i);
                JsonObject ikasleaJsonObject = Json.createObjectBuilder()
                                        .add("ikaslea", ikaslea.getIkaslea())
                                        .add("batezbestekoa", ikaslea.getBatezbestekoa())
                                        .build();
                builder.add(ikasleaJsonObject);
            }
            ikasleJsonArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(strFileOut));
            writer.writeArray(ikasleJsonArray);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;

    }
/* 
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
*/
    /**
     * ADI: Notak objetu bat jasotzen du metodo honek
     * @param notak
     * @return
     */
    public int idatzi(Notak notak) {
        Ikasleak ikasleak = new Ikasleak();
        ikasleak = notak.getIkasleenBB(); //METODO HAU ERE OSATU BEHAR DUZU DAGOKION LEKUAN
        List<Ikaslea> ikasleLista = ikasleak.getIkasleak();
        Ikaslea ikaslea = null;
        JsonArray jArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();

        try {
            for(int i = 0; i < ikasleLista.size(); i++){
                ikaslea = ikasleLista.get(i);
                JsonObject ikasleaJsonObject = Json.createObjectBuilder()
                                            .add("ikaslea", ikaslea.getIkaslea())
                                            .add("batazbestekoa", ikaslea.getBatezbestekoa())
                                            .build();
                builder.add(ikasleaJsonObject);
            }
            jArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(strFileOut));
            writer.writeArray(jArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ikasleLista.size();

    }
}
