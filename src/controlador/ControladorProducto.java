package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloProducto;
import vista.VentanaProducto;

public class ControladorProducto implements ActionListener {
    private String action;
    private VentanaProducto view;
    private String nameToRemove;

    public ControladorProducto(String action, VentanaProducto view) {
        this.action = action;
        this.view = view;
        view.VolverBtn.addActionListener(this);
        view.btnAdd.addActionListener(this);
        view.setVisible(true);
    }
    
    public void cargarDatos(String datos){
        if(datos == ""){
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia.");
            view.setVisible(false);
            return;
        }
        this.view.txtNombre.setText(datos.split(",")[1]);
        this.view.txtCant.setText(datos.split(",")[2]);
        this.nameToRemove = datos.split(",")[1];
    }
    
    public void crearProducto(){
        String producto = this.view.txtNombre.getText();
        int cant = Integer.parseInt(this.view.txtCant.getText());
        ModeloProducto modelProd = new ModeloProducto();
        if(modelProd.guardar("none", producto, cant)){
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }
    
    public void actualizarProducto(){
        String producto = this.view.txtNombre.getText();
        int cant = Integer.parseInt(this.view.txtCant.getText());
        ModeloProducto modelProd = new ModeloProducto();
        
        try {
            modelProd.eliminar(this.nameToRemove);
        } catch (IOException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(modelProd.guardar("none", producto, cant)){
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar datos.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == this.view.btnAdd){
            switch(action){
                case "create":
                    crearProducto();
                    break;
                case "update":
                    actualizarProducto();
                    break;
            }
        }else if(o == this.view.VolverBtn){
            this.view.setVisible(false);
        }
    }
}
