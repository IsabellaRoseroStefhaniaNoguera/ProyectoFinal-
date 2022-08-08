package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import modelo.ModeloProducto;
import modelo.ModeloProveedor;
import vista.VentanaCliente;
import vista.VentanaInicial;
import vista.VentanaListCli;
import vista.VentanaListProd;
import vista.VentanaListProv;
import vista.VentanaProducto;
import vista.VentanaProv;
import vista.VentanaTienda;

public class ControladorInicial implements ActionListener{
    
    private VentanaInicial view;

    public ControladorInicial(VentanaInicial view) {
        this.view = view;
        this.view.btnIniciar.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("Tienda UV");
        view.setLocationRelativeTo(null);
    }
    
    public void seleccionarAccion(){
        String PCR = this.view.cbxPCR.getSelectedItem().toString();
        String CRUD = this.view.cbxCRUD.getSelectedItem().toString();
        switch(PCR){
            case "Proovedor":
                proveedor(CRUD);
                break;
            case "Cliente":
                cliente(CRUD);
                break;
            case "Tienda":
                tienda();
                break;
            case "Producto":
                productos(CRUD);
                break;
        }
    }
    
    public void proveedor(String accion){
        VentanaProv provView = new VentanaProv();
        VentanaListProv provListView = new VentanaListProv();
        ModeloProveedor modeloProveedor = new ModeloProveedor();
        switch(accion){
            case "Agregar":
                new ControladorProveedores("create", provView);
                break;
            case "Listar":
                new ControladorListProveedores(provListView, modeloProveedor.obtenerProveedores());
                break;
            case "Eliminar":
                String ccDelete = JOptionPane.showInputDialog("Digita CC de Proveedor a eliminar:");
                try {
                    modeloProveedor.eliminar(ccDelete);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Actualizar":
                String ccEdit = JOptionPane.showInputDialog("Digita CC de Proveedor a actualizar:");
                ControladorProveedores editCtrl = new ControladorProveedores("update", provView);
                editCtrl.cargarDatos(modeloProveedor.obtenerProveedorPorCC(ccEdit));
                break;
        }
    }
    
    public void cliente(String accion){
        VentanaCliente clientView = new VentanaCliente();
        VentanaListCli clientListView = new VentanaListCli();
        ModeloCliente modeloCliente = new ModeloCliente();
        switch(accion){
            case "Agregar":
                new ControladorCliente("create", clientView);
                break;
            case "Listar":
                new ControladorListCliente(clientListView, modeloCliente.obtenerClientes());
                break;
            case "Eliminar":
                String cc = JOptionPane.showInputDialog("Digita CC de Cliente a eliminar:");
                try {
                    modeloCliente.eliminar(cc);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Actualizar":
                String ccEdit = JOptionPane.showInputDialog("Digita CC de Cliente a actualizar:");
                ControladorCliente editCtrl = new ControladorCliente("update", clientView);
                editCtrl.cargarDatos(modeloCliente.obtenerClientePorCC(ccEdit));
                break;
        }
    }
    
    public void tienda(){
        VentanaTienda ventanaTienda = new VentanaTienda();
        new ControladorTienda(ventanaTienda);
    }
    
    public void productos(String accion){
        VentanaProducto prodView = new VentanaProducto();
        VentanaListProd prodListview = new VentanaListProd();
        ModeloProducto modeloProducto = new ModeloProducto();
        switch(accion){
            case "Agregar":
                new ControladorProducto("create", prodView);
                break;
            case "Listar":
                new ControladorListProductos(prodListview, modeloProducto.obtenerProductos());
                modeloProducto.obtenerProductos();
                break;
            case "Eliminar":
                String name = JOptionPane.showInputDialog("Digita nombre de producto a eliminar:");
                try {
                    modeloProducto.eliminar(name);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Actualizar":
                String nameEdit = JOptionPane.showInputDialog("Digita nombre de producto a actualizar:");
                ControladorProducto prodCtrl = new ControladorProducto("update", prodView);
                prodCtrl.cargarDatos(modeloProducto.obtenerProductoPorNombre(nameEdit));
                break;
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == this.view.btnIniciar){
            seleccionarAccion();
        }
    }
}
