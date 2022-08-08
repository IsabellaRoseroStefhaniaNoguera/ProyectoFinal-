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


public class ModeloProveedor {
    public String obtenerProveedorPorCC(String CC){
        String proveedor = "";
        try {
          File myObj = new File("proveedores.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String linea = myReader.nextLine();
            if(linea.split(",")[2].equals(CC)){
                proveedor = linea;
            }
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return proveedor;
    }
    public String obtenerProveedores(){
        String proveedores = "";
        try {
          File myObj = new File("proveedores.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            proveedores += myReader.nextLine() + "\n";
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return proveedores;
    }
    public boolean guardar(String nombre, String apellido, String cc){
        if(nombre == "" || apellido == "" || cc == ""){
            return false;
        }
        try{
            String filename= "proveedores.txt";
            FileWriter fw = new FileWriter(filename,true);
            fw.write(nombre + "," + apellido + "," + cc + "\n");
            fw.close();
            return true;
        }catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
            return false;
        }
    }
    public void eliminar(String cc) throws FileNotFoundException, IOException{
        File f = new File("proveedores.txt");
        Scanner fileScanner = new Scanner(f);
        String lineasGuardadas = "";

        int lineNumber = 0;
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            if (!line.contains(cc)){
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
