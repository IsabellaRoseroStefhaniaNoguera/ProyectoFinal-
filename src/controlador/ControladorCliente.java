package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import vista.VentanaCliente;

public class ControladorCliente implements ActionListener{

    private String action;
    private VentanaCliente view;
    private String ccToRemove;

    public ControladorCliente(String action, VentanaCliente view) {
        this.action = action;
        this.view = view;
        view.setVisible(true);
        view.btnAccion.addActionListener(this);
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
    
    public void crearCliente(){
        String nombre = this.view.txtNombre.getText();
        String apellido = this.view.txtApellido.getText();
        String cc = this.view.txtCC.getText();
        
        ModeloCliente model = new ModeloCliente();
        if(model.guardar(nombre, apellido, cc)){
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }
    
    public void actualizarCliente(){
        String nombre = this.view.txtNombre.getText();
        String apellido = this.view.txtApellido.getText();
        String cc = this.view.txtCC.getText();
       
        ModeloCliente model = new ModeloCliente();
        
        try {
            model.eliminar(this.ccToRemove);
        } catch (IOException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(model.guardar(nombre, apellido, cc)){
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == this.view.btnAccion){
            switch(action){
                case "create":
                    crearCliente();
                    break;
                case "update":
                    actualizarCliente();
                    break;
            }
        }else if(o == this.view.btnVolver){
            this.view.setVisible(false);
        }
    }
}
