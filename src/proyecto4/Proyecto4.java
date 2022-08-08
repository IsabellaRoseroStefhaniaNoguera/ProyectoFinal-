/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto4;

import controlador.ControladorInicial;
import java.io.File;
import vista.VentanaCliente;
import vista.VentanaInicial;

/**
 *
 * @author USUARIO
 */
public class Proyecto4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaInicial view = new VentanaInicial();
        ControladorInicial ctrl = new ControladorInicial(view);
        ctrl.iniciar();
        view.setVisible(true);
    }
}
