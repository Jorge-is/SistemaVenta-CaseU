package vista;

import conexion.Conexion;
import java.sql.*;
import controlador.Ctrl_Producto;
import datos.Producto;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDProducto extends javax.swing.JDialog {

    private int idProducto;
    Producto pro = new Producto();
    Ctrl_Producto ct = new Ctrl_Producto();
    DefaultTableModel model = new DefaultTableModel();

    public JDProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.CargarTProducto();    
        this.FijarColumna();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdproducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        cboxIphone = new javax.swing.JComboBox<>();
        cboxVariante = new javax.swing.JComboBox<>();
        cboxNombre = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar producto");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID del Producto");

        txtIdproducto.setBackground(new java.awt.Color(204, 204, 255));
        txtIdproducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtIdproducto.setForeground(new java.awt.Color(0, 0, 0));
        txtIdproducto.setEnabled(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Variante");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tipo iPhone");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Precio");

        txtPrecio.setBackground(new java.awt.Color(204, 204, 255));
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Stock");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Descripción");

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 102, 255));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("REGISTRAR PRODUCTO");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caseu.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Buscar");

        txtBuscar.setBackground(new java.awt.Color(204, 204, 255));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtStock.setBackground(new java.awt.Color(204, 204, 255));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        cboxIphone.setBackground(new java.awt.Color(204, 204, 255));
        cboxIphone.setForeground(new java.awt.Color(0, 0, 0));
        cboxIphone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iPhone", "Iphone 11", "Iphone 11 Pro", "Iphone 11 Pro Max", "Iphone 12", "Iphone 12 Mini", "Iphone 12 Pro", "Iphone 12 Pro Max", "Iphone 13", "Iphone 13 Mini", "Iphone 13 Pro", "Iphone 13 Pro Max", "Iphone 14", "Iphone 14 Plus", "Iphone 14 Pro", "Iphone 14 Pro Max", "Iphone 15", "Iphone 15 Plus", "Iphone 15 Pro", "Iphone 15 Pro Max" }));
        cboxIphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxIphoneActionPerformed(evt);
            }
        });

        cboxVariante.setBackground(new java.awt.Color(204, 204, 255));
        cboxVariante.setForeground(new java.awt.Color(0, 0, 0));
        cboxVariante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione variante", "Transparente", "Plata", "Rojo", "Verde", "Negro", "Blanco", "Amarillo", "Morado", "Sin protector", "Con protector" }));
        cboxVariante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxVarianteActionPerformed(evt);
            }
        });

        cboxNombre.setBackground(new java.awt.Color(204, 204, 255));
        cboxNombre.setForeground(new java.awt.Color(0, 0, 0));
        cboxNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione case", "Mirror", "360", "Space Clear", "Arcoiris", "Silicona", "Mate", "MagSafe", "Elegante", "Deslizante", " " }));
        cboxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNombreActionPerformed(evt);
            }
        });

        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Variante", "iPhone", "Precio", "Stock", "Descripción"
            }
        ));
        jScrollPane3.setViewportView(jtbProducto);
        if (jtbProducto.getColumnModel().getColumnCount() > 0) {
            jtbProducto.getColumnModel().getColumn(0).setResizable(false);
            jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbProducto.getColumnModel().getColumn(1).setResizable(false);
            jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxIphone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxVariante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStock)
                                    .addComponent(txtPrecio))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboxVariante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxIphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (cboxNombre.getSelectedItem().toString().equals("Seleccione case") || cboxVariante.getSelectedItem().toString().equals("Seleccione variante") || cboxIphone.getSelectedItem().toString().equals("Seleccione iPhone") || txtStock.getText().equals("") || txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            cboxNombre.setBackground(Color.red);
            cboxVariante.setBackground(Color.red);
            cboxIphone.setBackground(Color.red);
            txtStock.setBackground(Color.red);
            txtPrecio.setBackground(Color.red);
        } else {
            try {
                pro.setNombre(cboxNombre.getSelectedItem().toString().trim());
                pro.setVariante(cboxVariante.getSelectedItem().toString().trim());
                pro.setIphone(cboxIphone.getSelectedItem().toString().trim());
                pro.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
                pro.setStock(Integer.parseInt(txtStock.getText().trim()));
                pro.setDescripcion(txtDescripcion.getText().trim());
                if (ct.guardar(pro)) {
                    JOptionPane.showMessageDialog(null, "Producto registrado");
                    this.CargarTProducto();
                    this.FijarColumna();
                    this.Limpiar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (cboxNombre.getSelectedItem().toString().isEmpty() && cboxVariante.getSelectedItem().toString().isEmpty() && cboxIphone.getSelectedItem().toString().isEmpty() && txtPrecio.getText().isEmpty() && txtStock.getText().isEmpty() && txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {

            if (!ct.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.Limpiar();
                this.CargarTProducto();
                this.FijarColumna();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (cboxNombre.getSelectedItem().toString().isEmpty() && cboxVariante.getSelectedItem().toString().isEmpty() && cboxIphone.getSelectedItem().toString().isEmpty() && txtPrecio.getText().isEmpty() && txtStock.getText().isEmpty() && txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {

            pro.setNombre(cboxNombre.getSelectedItem().toString().trim());
            pro.setVariante(cboxVariante.getSelectedItem().toString().trim());
            pro.setIphone(cboxIphone.getSelectedItem().toString().trim());
            pro.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
            pro.setStock(Integer.parseInt(txtStock.getText().trim()));
            pro.setDescripcion(txtDescripcion.getText().trim());

            if (ct.actualizar(pro, idProducto)) {
                JOptionPane.showMessageDialog(null, "Datos del producto actualizados");
                this.Limpiar();
                this.CargarTProducto();
                this.FijarColumna();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdproducto.setText("");
        this.cboxNombre.setSelectedItem("Seleccione case");
        this.cboxVariante.setSelectedItem("Seleccione variante");
        this.cboxIphone.setSelectedItem("Seleccione iPhone");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cboxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxNombreActionPerformed
        cboxNombre.transferFocus();
    }//GEN-LAST:event_cboxNombreActionPerformed

    private void cboxVarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxVarianteActionPerformed
        cboxVariante.transferFocus();
    }//GEN-LAST:event_cboxVarianteActionPerformed

    private void cboxIphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxIphoneActionPerformed
        cboxIphone.transferFocus();
    }//GEN-LAST:event_cboxIphoneActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        txtStock.transferFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.Buscar(txtBuscar.getText());
        this.FijarColumna();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDProducto dialog = new JDProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboxIphone;
    private javax.swing.JComboBox<String> cboxNombre;
    private javax.swing.JComboBox<String> cboxVariante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdproducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txtIdproducto.setText("");
        this.cboxNombre.setSelectedItem("Seleccione case");
        this.cboxVariante.setSelectedItem("Seleccione variante");
        this.cboxIphone.setSelectedItem("Seleccione iPhone");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
    }

    private void Buscar(String buscar) {
        try {
            DefaultTableModel model;
            model = ct.buscar(buscar);
            jtbProducto.setModel(model);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    private void CargarTProducto() {
        model.setRowCount(0);
        model.setColumnCount(0);
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            JDProducto.jtbProducto = new JTable(model);
            JDProducto.jScrollPane3.setViewportView(JDProducto.jtbProducto);

            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Variante");
            model.addColumn("iPhone");
            model.addColumn("Precio");
            model.addColumn("Stock");
            model.addColumn("Descripción");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla producto" + e);
        }

        jtbProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jtbProducto.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSelec(idProducto);
                }
            }
        });
    }

    private void EnviarDatosProductoSelec(int idProducto) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT * FROM producto WHERE idProducto = '" + idProducto + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtIdproducto.setText(rs.getString("idProducto"));
                cboxNombre.setSelectedItem(rs.getString("nombre"));
                cboxVariante.setSelectedItem(rs.getString("variante"));
                cboxIphone.setSelectedItem(rs.getString("iphone"));
                txtPrecio.setText(rs.getString("precio"));
                txtStock.setText(rs.getString("stock"));
                txtDescripcion.setText(rs.getString("descripcion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al selecionar producto " + e);
        }
    }
    
    //Tamaño del ancho de las columnas y filarlos
    private void FijarColumna() {
        jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(0).setResizable(false);
        jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtbProducto.getColumnModel().getColumn(1).setResizable(false);
        jtbProducto.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtbProducto.getColumnModel().getColumn(2).setResizable(false);
        jtbProducto.getColumnModel().getColumn(3).setPreferredWidth(80);
        jtbProducto.getColumnModel().getColumn(3).setResizable(false);
        jtbProducto.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(4).setResizable(false);
        jtbProducto.getColumnModel().getColumn(5).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(5).setResizable(false);
        jtbProducto.getColumnModel().getColumn(6).setPreferredWidth(50);
        jtbProducto.getColumnModel().getColumn(6).setResizable(false);
        
        jtbProducto.setRowHeight(20);
    }
}
