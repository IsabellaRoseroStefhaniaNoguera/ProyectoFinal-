/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author USUARIO
 */
public class VentanaInicial extends javax.swing.JFrame {

    /**
     * Creates new form VentanaListProd
     */
    public VentanaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxCRUD = new javax.swing.JComboBox<>();
        cbxPCR = new javax.swing.JComboBox<>();
        btnIniciar = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxCRUD.setBackground(new java.awt.Color(255, 204, 204));
        cbxCRUD.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        cbxCRUD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar", "Listar", "Eliminar", "Actualizar" }));
        jPanel1.add(cbxCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 178, 146, 31));

        cbxPCR.setBackground(new java.awt.Color(255, 204, 204));
        cbxPCR.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        cbxPCR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proovedor", "Producto", "Cliente", "Tienda" }));
        cbxPCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPCRActionPerformed(evt);
            }
        });
        jPanel1.add(cbxPCR, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 117, 146, 31));

        btnIniciar.setBackground(new java.awt.Color(255, 204, 204));
        btnIniciar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnIniciar.setText("INICIAR");
        btnIniciar.setActionCommand("btnIniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 245, 125, 34));

        txtTitulo.setBackground(new java.awt.Color(255, 204, 204));
        txtTitulo.setFont(new java.awt.Font("ARCO", 0, 24)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setText("SUPERMERCADO UNIVALLE");
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void cbxPCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPCRActionPerformed
       
    }//GEN-LAST:event_cbxPCRActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        
        
        
        
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIniciar;
    public javax.swing.JComboBox<String> cbxCRUD;
    public javax.swing.JComboBox<String> cbxPCR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
