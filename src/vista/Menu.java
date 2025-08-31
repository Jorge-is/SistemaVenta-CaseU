package vista;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnInicio = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        btnUsuario = new javax.swing.JMenu();
        btnCrearusuario = new javax.swing.JMenuItem();
        btnAdministrar = new javax.swing.JMenuItem();
        btnProducto = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        btnCliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnVenta = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnStock = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnCerrar = new javax.swing.JMenu();
        jMCerrar = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de venta de case");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caseu.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Case predeterminados y personalizados");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/goku.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mario.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokemon.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 500));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setForeground(new java.awt.Color(0, 0, 0));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciomenu.png"))); // NOI18N
        btnInicio.setText("Inicio");

        jMenuItem6.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem6.setText("Cambiar acceso");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        btnInicio.add(jMenuItem6);

        jMenuBar1.add(btnInicio);

        btnUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usumenu.png"))); // NOI18N
        btnUsuario.setText("Usuario");

        btnCrearusuario.setBackground(new java.awt.Color(255, 255, 255));
        btnCrearusuario.setForeground(new java.awt.Color(0, 0, 0));
        btnCrearusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevousu.png"))); // NOI18N
        btnCrearusuario.setText("Crear usuario");
        btnCrearusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearusuarioActionPerformed(evt);
            }
        });
        btnUsuario.add(btnCrearusuario);

        btnAdministrar.setBackground(new java.awt.Color(255, 255, 255));
        btnAdministrar.setForeground(new java.awt.Color(0, 0, 0));
        btnAdministrar.setText("Administrar usuario");
        btnAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarActionPerformed(evt);
            }
        });
        btnUsuario.add(btnAdministrar);

        jMenuBar1.add(btnUsuario);

        btnProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iphone.png"))); // NOI18N
        btnProducto.setText("Producto");

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevocase.png"))); // NOI18N
        jMenuItem5.setText("Registrar producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        btnProducto.add(jMenuItem5);

        jMenuBar1.add(btnProducto);

        btnCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clientemenu.png"))); // NOI18N
        btnCliente.setText("Cliente");

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarcliente.png"))); // NOI18N
        jMenuItem1.setText("Registrar cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btnCliente.add(jMenuItem1);

        jMenuBar1.add(btnCliente);

        btnVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnVenta.setForeground(new java.awt.Color(0, 0, 0));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/venta.png"))); // NOI18N
        btnVenta.setText("Venta");

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarventa.png"))); // NOI18N
        jMenuItem3.setText("Generar venta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        btnVenta.add(jMenuItem3);

        jMenuBar1.add(btnVenta);

        btnStock.setBackground(new java.awt.Color(255, 255, 255));
        btnStock.setForeground(new java.awt.Color(0, 0, 0));
        btnStock.setText("Stock");

        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem2.setText("Agregar stock");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        btnStock.add(jMenuItem2);

        jMenuBar1.add(btnStock);

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrarsesion.png"))); // NOI18N
        btnCerrar.setText("Cerrar Sesión");

        jMCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jMCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jMCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jMCerrar.setText("Cerrar");
        jMCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCerrarActionPerformed(evt);
            }
        });
        btnCerrar.add(jMCerrar);

        jMenuBar1.add(btnCerrar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDCliente cl = new JDCliente(this, true);
        cl.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JDProducto vt = new JDProducto(this, true);
        vt.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Stock pr = new Stock(this, true);
        pr.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnCrearusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearusuarioActionPerformed
        Registrar rg = new Registrar(this, true);
        rg.setVisible(true);
    }//GEN-LAST:event_btnCrearusuarioActionPerformed

    private void btnAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarActionPerformed
        GestionarUsuario usu = new GestionarUsuario(this, true);
        usu.setVisible(true);
    }//GEN-LAST:event_btnAdministrarActionPerformed

    private void jMCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMCerrarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDVenta vt = new JDVenta(this, true);
        vt.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAdministrar;
    private javax.swing.JMenu btnCerrar;
    private javax.swing.JMenu btnCliente;
    private javax.swing.JMenuItem btnCrearusuario;
    private javax.swing.JMenu btnInicio;
    private javax.swing.JMenu btnProducto;
    private javax.swing.JMenu btnStock;
    private javax.swing.JMenu btnUsuario;
    private javax.swing.JMenu btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMCerrar;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void Privilegios(String categoria) {

        if ("Administrador".equals(categoria)) {
            btnInicio.setEnabled(true);
            btnUsuario.setEnabled(true);
            btnProducto.setEnabled(true);
            btnCliente.setEnabled(true);
            btnStock.setEnabled(true);
            btnVenta.setEnabled(true);
            btnCerrar.setEnabled(true);
        } else if ("Vendedor".equals(categoria)) {
            btnInicio.setVisible(false);
            btnUsuario.setVisible(false);
            btnProducto.setVisible(false);
            btnStock.setVisible(false);
        }
    }
}
