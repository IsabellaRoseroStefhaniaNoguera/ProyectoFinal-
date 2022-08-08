/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class ModeloProducto {
    public String obtenerProductoPorNombre(String nombre){
        String producto = "";
        try {
          File myObj = new File("productos.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String linea = myReader.nextLine();
            if(linea.split(",")[1].equals(nombre)){
                producto = linea;
            }
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return producto;
    }
    public ArrayList<String> obtenerNombreProductos(){
        ArrayList<String> nombres = new ArrayList<String>();
        try {
          File myObj = new File("productos.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String producto = myReader.nextLine();
            nombres.add(producto.split(",")[1]);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return nombres;
    }
    public String obtenerProductos(){
        String productos = "";
        try {
          File myObj = new File("productos.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            productos += myReader.nextLine() + "\n";
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return productos;
    }
    public boolean guardar(String proveedor, String nombre, int cantidad){
        if(proveedor == "" || nombre == "" || cantidad <= 0){
            return false;
        }
        try{
            String filename= "productos.txt";
            FileWriter fw = new FileWriter(filename,true);
            fw.write(proveedor + "," + nombre + "," + cantidad + "\n");
            fw.close();
            return true;
        }catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
            return false;
        }
    }
    public void eliminar(String nombre) throws FileNotFoundException, IOException{
        File f = new File("productos.txt");
        Scanner fileScanner = new Scanner(f);
        String lineasGuardadas = "";

        int lineNumber = 0;
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            if (!line.contains(nombre)){
                lineasGuardadas += line + "\n";
            }
            lineNumber++;
        }
        
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(f));
        bw2.write(lineasGuardadas);
        bw2.close();

        fileScanner.close();
    }
}
