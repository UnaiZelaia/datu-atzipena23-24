package dambi;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File arrainak = new File("karpetaBerria/animaliak/arrainak");
        File ugaztunak = new File("karpetaBerria/animaliak/ugaztunak");
        File barazkiak = new File("karpetaBerria/elikagaiak/barazkiak");
        File esnekiak = new File("karpetaBerria/elikagaiak/esnekiak");

        arrainak.mkdirs();
        ugaztunak.mkdirs();
        barazkiak.mkdirs();
        esnekiak.mkdirs();
    }
}
