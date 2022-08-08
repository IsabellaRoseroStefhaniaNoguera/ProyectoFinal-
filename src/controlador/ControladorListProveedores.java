/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaListProv;

public class ControladorListProveedores implements ActionListener{
    private VentanaListProv view;
    private String datos;

    ControladorListProveedores(VentanaListProv view, String datos) {
        this.view = view;
        this.datos = datos;
        this.view.setVisible(true);
        this.view.textarea.setText(datos);
        this.view.cerrarBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.view.setVisible(false);
    }
}
