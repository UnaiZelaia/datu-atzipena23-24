package dambi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;

public class MainMenua {
    public static void main(String[] args) {
        int c = 1;
        Scanner in = new Scanner(System.in);

        while (c == 1) {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Mendi baten altuera ikusi");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            String auk = in.next();
            if (Integer.valueOf(auk) > 0 && Integer.valueOf(auk) <= 5) {
                switch (Integer.valueOf(auk)) {
                    case 1:


                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("Mendiak.csv"));
                            System.out.printf("%12s | %8s | %s%n", "MENDIA", "ALTUERA", "PROBINTZIA");
                            System.out.println("-------------------------------------------");
                            while (reader.readLine() != null) {
                                String[] mendia = reader.readLine().split(";");
                                System.out.printf("%12s | %8s | %s%n", mendia[0], mendia[1], mendia[2]);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Errore bat egon da: " + e.getMessage());
                        } catch (IOException eio) {
                            System.out.println("Errore bat egon da: " + eio.getMessage());
                        }
                        break;


                    case 2:
                        try {
                            String[] mendiAltuena = new String[3];
                            BufferedReader reader = new BufferedReader(new FileReader("Mendiak.csv"));
                            while (reader.readLine() != null) {
                                String[] mendia = reader.readLine().split(";");
                                mendiAltuena = mendia;
                                if(Integer.parseInt(mendiAltuena[1]) < Integer.parseInt(mendia[1])){
                                    mendiAltuena = mendia;
                                }
                            }
                            System.out.println("Mendi altuena: " + mendiAltuena[0]);
                        } catch (FileNotFoundException e) {
                            System.out.println("Errore bat egon da: " + e.getMessage());
                        } catch (IOException eio) {
                            System.out.println("Errore bat egon da: " + eio.getMessage());
                        }
                    break;


                    case 3:
                        try{
                            BufferedReader reader = new BufferedReader(new FileReader("Mendiak.csv"));

                            File bizkaiaCsv = new File("bizkaia.csv");
                            bizkaiaCsv.createNewFile();

                            File gipuzkoaCsv = new File("gipuzkoa.csv");
                            gipuzkoaCsv.createNewFile();

                            File arabaCsv = new File("araba.csv");
                            arabaCsv.createNewFile();

                            File nafarroaCsv = new File("nafarroa.csv");
                            nafarroaCsv.createNewFile();
                            
                            FileWriter fwBizkaia = new FileWriter(bizkaiaCsv, false);
                            BufferedWriter writerBiz = new BufferedWriter(fwBizkaia);
                            writerBiz.write("MENDIA;ALTUERA\n");

                            FileWriter fwGipuzkoa = new FileWriter(gipuzkoaCsv, false);
                            BufferedWriter writerGip = new BufferedWriter(fwGipuzkoa);
                            writerGip.write("MENDIA;ALTUERA\n");

                            FileWriter fwAraba = new FileWriter(arabaCsv, false);
                            BufferedWriter writerAra = new BufferedWriter(fwAraba);
                            writerAra.write("MENDIA;ALTUERA\n");

                            FileWriter fwNafarroa = new FileWriter(nafarroaCsv, false);
                            BufferedWriter writerNaf = new BufferedWriter(fwNafarroa);
                            writerNaf.write("MENDIA;ALTUERA\n");

                            while (reader.readLine() != null) {
                                String[] mendia = reader.readLine().split(";");
                                String probintzia = mendia[2];

                                if(probintzia.toUpperCase().equals("BIZKAIA")){
                                    writerBiz.write(mendia[0] + ";" + mendia[1] + "\n");
                                }
                                else if(probintzia.toUpperCase().equals("GIPUZKOA")){
                                    writerGip.write(mendia[0] + ";" + mendia[1] + "\n");
                                }
                                else if(probintzia.toUpperCase().equals("ARABA")){
                                    writerAra.write(mendia[0] + ";" + mendia[1] + "\n");
                                }
                                else if(probintzia.toUpperCase().equals("NAFARROA")){
                                    writerNaf.write(mendia[0] + ";" + mendia[1] + "\n");
                                }
                            }
                            writerBiz.close();
                            writerAra.close();
                            writerGip.close();
                            writerNaf.close();
                            reader.close();

                        }
                        catch (FileNotFoundException e) {
                            System.out.println("Errore bat egon da: " + e.getMessage());
                        } catch (IOException eio) {
                            System.out.println("Errore bat egon da: " + eio.getMessage());
                        }
                    break;


                    case 4:
                        try {
                            String[][] mendiak = new String[50][];
                            String[] mendia = new String[3];
                            BufferedReader reader = new BufferedReader(new FileReader("Mendiak.csv"));
                            int count = 1;
                            while (reader.readLine() != null) {
                                mendia = reader.readLine().split(";");
                                mendiak[count] = mendia;
                                System.out.printf("%3d | %s%n", count, mendia[0]);
                                count++;
                            }
                            System.out.print("Aukeratu mendi bat: ");
                            int aukMen = in.nextInt();
                            System.out.println(mendiak[aukMen][0] + " mendiaren altuera " + mendiak[aukMen][1] + " da.");

                        } catch (FileNotFoundException e) {
                            System.out.println("Errore bat egon da: " + e.getMessage());
                        } catch (IOException eio) {
                            System.out.println("Errore bat egon da: " + eio.getMessage());
                        }
                    break;
                    case 5:
                    System.out.println("Agur!!");
                    c = 0;
                    break;
                }
            } else {
                System.out.println(
                        "Errore bat egon da zure aukerarekin. Mesedez 1 eta 5 artean dagoen zenbaki bat aukeratu");
            }
        }
    }
}
