package dambi.atzipenekoak;

import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.*;
import dambi.pojoak.*;

public class proba {
    public static void main(String[] args) {
        Csva csv = new Csva("mendiak.csv");
        Jsona jsona = new Jsona("mendiak.json", "mendiak.json");

        Mendiak mendiak = new Mendiak();

        mendiak = csv.irakurri();

        int i = jsona.idatzi(mendiak);
        System.out.println(i + " mendi idatzi dira.");
    }
}
