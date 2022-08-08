/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import modelo.ModeloProducto;
import modelo.ModeloVentas;
import vista.VentanaTienda;

public class ControladorTienda implements ActionListener{
    private VentanaTienda view;

    ControladorTienda(VentanaTienda view) {
        this.view = view;
        this.view.setVisible(true);
        this.view.pagarBtn.addActionListener(this);
        this.view.VolverBtn.addActionListener(this);
        cargarClientes();
        cargarProductos();
    }
    
    public void cargarClientes(){
        ModeloCliente clientModelo = new ModeloCliente();
        clientModelo.obtenerNombreClientes().forEach((name) -> this.view.clientCbx.addItem(name));
    }
    
    public void cargarProductos(){
        ModeloProducto productModelo = new ModeloProducto();
        productModelo.obtenerNombreProductos().forEach((name) -> this.view.prodCbx.addItem(name));
    }
    
    public void pagar(){
        String cliente = this.view.clientCbx.getSelectedItem().toString();
        String producto = this.view.prodCbx.getSelectedItem().toString();
        int cantidad = Integer.parseInt(this.view.cantCbx.getText());
        ModeloVentas salesModelo = new ModeloVentas();
        if(salesModelo.guardar(cliente, producto, cantidad)){
            JOptionPane.showMessageDialog(null, "Se realizo la venta correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == this.view.pagarBtn){
            pagar();
        }else if(o == this.view.VolverBtn){
            this.view.setVisible(false);
        }
    }
}
