package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1){
                out.write(c);
            }
        } catch (IOException e){
            System.out.println("There was an error in the IOStream: " + e.getMessage());
        } finally{
            try{
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        } catch(IOException e){
            System.out.println("There was an error in the IOStream: " + e.getMessage());
        }
        }
        
    }
}