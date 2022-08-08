/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloProducto;
import modelo.ModeloProveedor;
import vista.VentanaProv;


public class ControladorProveedores implements ActionListener{
    private String action;
    private VentanaProv view;
    private String ccToRemove;

    public ControladorProveedores(String action, VentanaProv view) {
        this.action = action;
        this.view = view;
        view.setVisible(true);
        view.btnAcccion.addActionListener(this);
        view.btnVolver.addActionListener(this);
    }
    
    public void cargarDatos(String datos){
        if(datos == ""){
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia.");
            view.setVisible(false);
            return;
        }
        
        this.view.txtNombre.setText(datos.split(",")[0]);
        this.view.txtApellido.setText(datos.split(",")[1]);
        this.view.txtCC.setText(datos.split(",")[2]);
        this.ccToRemove = datos.split(",")[2];
    }
    
    public void crearProveedor(){
        String nombre = this.view.txtNombre.getText();
        String apellido = this.view.txtApellido.getText();
        String cc = this.view.txtCC.getText();
        
        ModeloProveedor provModel = new ModeloProveedor();
        
        provModel.guardar(nombre, apellido, cc);
        crearProducto(cc);
    }
    
    public void crearProducto(String proveedor){
        String producto = this.view.txtProducto.getText();
        int cantidad = Integer.parseInt(this.view.txtCantidad.getText());
        
        ModeloProducto prodModel = new ModeloProducto();
        prodModel.guardar(proveedor, producto, cantidad);
    }
    
    public void actualizarProveedor(){
        String nombre = this.view.txtNombre.getText();
        String apellido = this.view.txtApellido.getText();
        String cc = this.view.txtCC.getText();
        
        ModeloProveedor provModel = new ModeloProveedor();
        
        try {
            provModel.eliminar(this.ccToRemove);
        } catch (IOException ex) {
            Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(provModel.guardar(nombre, apellido, cc)){
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == this.view.btnAcccion){
            switch(action){
                case "create":
                    crearProveedor();
                    break;
                case "update":
                    actualizarProveedor();
                    break;
            }
        }else if(o == this.view.btnVolver){
            this.view.setVisible(false);
        }
    }
}
