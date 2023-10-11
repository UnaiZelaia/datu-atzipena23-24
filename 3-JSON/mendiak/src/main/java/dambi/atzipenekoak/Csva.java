package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import dambi.pojoak.*;

public class Csva {
    private String strFileIn;
    private String strFileOut;

    // Constructors
    public Csva(String fileIn) {
        this.strFileIn = "data/" +fileIn;
    }

    public Csva(String fileIn, String fileOut) {
        this.strFileIn = "data/" +fileIn;
        this.strFileOut = "data/" +fileOut;
    }

    public Mendiak irakurri() {
        Mendiak mendiak = new Mendiak();
        List<Mendia> mendiakList = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            while (inputStream.readLine() != null) {
                String[] mendia = inputStream.readLine().split(";");
                Mendia mendiaObj = new Mendia(Integer.parseInt(mendia[0]), mendia[1], Integer.parseInt(mendia[2]),
                        mendia[3]);
                mendiakList.add(mendiaObj);
            }
            mendiak.setMendiak(mendiakList);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mendiak;
    }



    public int idatzi(Mendiak mendiak) {
        int i = 0;
        List<Mendia> mendiakList = mendiak.getMendiak();
        try {
            //Declare and create file for writting. The file name and path are determined by strFileOut variable
            File mendiakFile = new File(strFileOut);
            mendiakFile.createNewFile();

            //Declare writer
            FileWriter fwMendiak = new FileWriter(mendiakFile, false);
            BufferedWriter writerMendiak = new BufferedWriter(fwMendiak);

            //Iterate over object Mendiak List<Mendia> and write the content into csv separated by ";"
            for (i = 0; i < mendiakList.size(); i++) {
                writerMendiak.write(mendiakList.get(i).getId() + ";" + mendiakList.get(i).getMendia() + ";"
                        + mendiakList.get(i).getProbintzia() + "\n");
            }
            fwMendiak.close();
            writerMendiak.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return i;
    }
}
