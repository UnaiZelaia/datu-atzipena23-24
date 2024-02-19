package dambi;

import java.util.List;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class NotakIgo {
    public static void main(String[] args) {
        Csva csv = new Csva("datuak/Notak.csv");
        Xmla xml = new Xmla("datuak/xmlIn.xml", "datuak/xmlout.xml");

        Notak notak = csv.irakurri();
        List<Nota> notakList = notak.getNotak();

        int count = 0;
        for(Nota nota : notakList){
            if(nota.getNota() <= 9){
                nota.setNota(nota.getNota() + 1);
            } else{
                nota.setNota(10);
            }
            count++;
        }
        xml.idatzi(notak);
        System.out.println(count + " nota idatzi dir xml fitxategian.");
    }
}
