package view;

import controller.ArregloMascota;
import javax.swing.JOptionPane;
import model.Mascota;

public class JFMascota extends javax.swing.JFrame {

    public JFMascota() {
        initComponents();
    }
    
    //crear objeto
    ArregloMascota m = new ArregloMascota();
    
    //---------------------------------------------------
    int getCodigo(){
        return Integer.parseInt(txtCodigo.getText());
    }
    int getEdad(){
        return Integer.parseInt(txtEdad.getText());
    }
    String getRaza(){
        return txtRaza.getText();
    }
    double getPeso(){
        return Double.parseDouble(txtPeso.getText());
    }
    int getNumeroVacunas(){
        return Integer.parseInt(txtNumero.getText());
    }
    void mensaje(String m,String tipo){
        JOptionPane.showMessageDialog(this, m,tipo,JOptionPane.INFORMATION_MESSAGE);
    }
    String rellena(String cad){
        int longitud=cad.length();
        for (int i = 0; i <15; i++) {
            cad+=" ";
        }
        return cad;
    }
    void imprimir(){
        bandeja.setText("");
    }
    void imprimir(String s){
        bandeja.append(s+"\n");
    }
    //metodo listar
    void listar(){
        imprimir();
        if (m.tamaño()>0) {
            imprimir("codigo \t Edad \t Raza \t\t Peso \t Nro. de vacunas");
            for (int i = 0; i < m.tamaño(); i++) {
                Mascota masco=m.obtener(i);
                imprimir(masco.getCodigo()+"\t"+masco.getEdad()+"\t"+masco.getRaza()+"\t\t"+
                        masco.getPeso()+"\t\t"+masco.getNumeroVacunas());
            }
            imprimir("");
            imprimir("Total de Mascotas:"+m.tamaño());
        }else{
            imprimir("No hay Mascotas registradas");
        }
    }
    //metodo ingresar
    void ingresar(){
        Mascota masco=m.buscar(getCodigo());
        if (masco==null) {
            masco = new Mascota(getCodigo(),getEdad(),getRaza(),getPeso(),getNumeroVacunas());
            m.adicionar(masco);
            listar();
            mensaje("Mascota Ingresada", "Mensaje de confirmacion");
        }else{
            mensaje("Codigo ya registrado","Mensaje de error");
        }
    }
    //metodo consultar
    void consultar(){
        imprimir();
        Mascota masco=m.buscar(getCodigo());
        if (masco!=null) {
            imprimir("Codigo            :"+masco.getCodigo());
            imprimir("Edad         :"+masco.getEdad());
            imprimir("Raza       :"+masco.getRaza());
            imprimir("Peso   :"+masco.getPeso());
            imprimir("Nro. de vacunas             :"+masco.getNumeroVacunas());
        }else{
            mensaje("Mascota no existe","Mensaje de error");
        }
    }
    //metodo modificar
    void modificar(){
        Mascota masco=m.buscar(getCodigo());
        if (masco!=null) {
            masco.setEdad(getEdad());
            masco.setRaza(getRaza());
            masco.setPeso(getPeso());
            masco.setNumeroVacunas(getNumeroVacunas());
            listar();
            mensaje("Mascota Modificada", "Mensaje de confirmacion");
        }else{
            mensaje("Mascota no existe", "Mensaje de error");
        }
    }
    //metodo eliminar
    void eliminar(){
        Mascota masco=m.buscar(getCodigo());
        if (masco!=null) {
            m.eliminar(masco);
            listar();
            mensaje("Mascota Eliminada", "Mensaje de confirmacion");
        }else{
            mensaje("Mascota no existe", "Mensaje de error");
        }
    }
    //metodo borrar
    void borrar(){
        txtCodigo.setText("");
        txtEdad.setText("");
        txtRaza.setText("");
        txtPeso.setText("");
        txtNumero.setText("");
        txtCodigo.requestFocus();
    }
    void procesar(){
        switch(cboOpcion.getSelectedIndex()){
            case 0: ingresar();
                    break;
            case 1: consultar();
                    break;
            case 2: modificar();
                   break;
            default: eliminar();
        }
    }
    void seleccionar(){
        int opcion=cboOpcion.getSelectedIndex();
        if (opcion==1 || opcion==3) {
            txtEdad.setVisible(false);
            lblEdad.setVisible(false);
            txtRaza.setVisible(false);
            lblRaza.setVisible(false);
            lblPeso.setVisible(false);
            txtPeso.setVisible(false);
            lblKg.setVisible(false);
            lblNumero.setVisible(false);
            txtNumero.setVisible(false);
        }else{
            txtEdad.setVisible(true);
            lblEdad.setVisible(true);
            txtRaza.setVisible(true);
            lblRaza.setVisible(true);
            lblPeso.setVisible(true);
            txtPeso.setVisible(true);
            lblKg.setVisible(true);
            lblNumero.setVisible(true);
            txtNumero.setVisible(true);
        }
    }
    void cerrar(){
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPeso = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bandeja = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        cboOpcion = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblKg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bandeja.setColumns(20);
        bandeja.setRows(5);
        jScrollPane1.setViewportView(bandeja);

        jLabel1.setText("Opcion:");

        lblCodigo.setText("Codigo de la mascota:");

        lblRaza.setText("Raza:");

        lblPeso.setText("Peso:");

        lblNumero.setText("Nro. Vacunas:");

        cboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingresar", "consultar", "modificar", "eliminar" }));
        cboOpcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOpcionItemStateChanged(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("REGISTRO VETERINARIA");

        lblEdad.setText("Edad:");

        lblKg.setText("KG.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lblNumero))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 142, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPeso)
                            .addComponent(lblRaza))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblKg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(lblCodigo)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProcesar)
                            .addComponent(btnCerrar)
                            .addComponent(btnLimpiar))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnProcesar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRaza)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeso)
                            .addComponent(lblKg))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboOpcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOpcionItemStateChanged
        seleccionar();
    }//GEN-LAST:event_cboOpcionItemStateChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        borrar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        procesar();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bandeja;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> cboOpcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblKg;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
