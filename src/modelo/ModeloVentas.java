package modelo;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class ModeloVentas {
    public boolean guardar(String cliente, String producto, int cantidad){
        if(cliente == "" || producto == "" || cantidad <= 0){
            return false;
        }
        try{
            String filename= "ventas.txt";
            FileWriter fw = new FileWriter(filename,true);
            fw.write(cliente + " ha comprado " + cantidad + " de " + producto + "\n");
            fw.close();
            return true;
        }catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
            return false;
        }
    }
}
