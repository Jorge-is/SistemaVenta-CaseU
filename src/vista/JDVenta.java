package vista;

import java.sql.*;
import java.util.Date;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import controlador.VentaPDF;
import datos.DetalleVenta;
import datos.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDVenta extends javax.swing.JDialog {

    private DefaultTableModel model;
    //Lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProducto = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0; //Id del cliente seleccionado

    private int idProducto = 0;
    private String nombre = "";
    private String variante = "";
    private String iphone = "";
    private int cantidadBBDD = 0;
    private double preUnitario = 0.0;

    private int cantidad = 0; //Cantidad de productos a comprar
    private double subtotal = 0.0; //Cantidad por precio
    private double descuento = 0.0;
    private double igv = 0.0;
    private double totalPagar = 0.0;

    //Variables para calculos generales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double igvGeneral = 0.0;
    private double totalPagarGeneral = 0.0;

    //ID de Detalle venta
    private int auxIdDetalle = 1;

    public JDVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.CargarComboClientes();
        this.CargarComboProductos();
        this.TablaProducto();

        txtSubtotal.setText("0.0");
        txtDescuento.setText("0.0");
        txtIgv.setText("0.0");
        txtTotal.setText("0.0");
        this.FijarColumna();
    }

    private void TablaProducto() {
        model = new DefaultTableModel();
        //Añadir columnas
        model.addColumn("N");
        model.addColumn("Nombre");
        model.addColumn("Variante");
        model.addColumn("iPhone");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("SubT");
        model.addColumn("Desc");
        model.addColumn("IGV");
        model.addColumn("Total");
        //Agregar datos a la tabla
        this.jtbVenta.setModel(model);
    }

    //Metodo para presentar la info de la tabla detalle venta
    private void listaTablaProducto() {
        this.model.setRowCount(listaProducto.size());
//        for (int i = 0; i < listaProducto.size(); i++) {
//            this.model.setValueAt(i + 1, i, 0);
//            this.model.setValueAt(listaProducto.get(i).getNombre(), i, 1);
//            this.model.setValueAt(listaProducto.get(i).getCantidad(), i, 2);
//            this.model.setValueAt(listaProducto.get(i).getPreUnitario(), i, 3);
//            this.model.setValueAt(listaProducto.get(i).getSubTotal(), i, 4);
//            this.model.setValueAt(listaProducto.get(i).getDescuento(), i, 5);
//            this.model.setValueAt(listaProducto.get(i).getIgv(), i, 6);
//            this.model.setValueAt(listaProducto.get(i).getTotalpagar(), i, 7);
//        }
        for (int i = 0; i < listaProducto.size(); i++) {
            this.model.setValueAt(i + 1, i, 0);
            this.model.setValueAt(listaProducto.get(i).getNombre(), i, 1);
            this.model.setValueAt(listaProducto.get(i).getVariante(), i, 2);
            this.model.setValueAt(listaProducto.get(i).getIphone(), i, 3);
            this.model.setValueAt(listaProducto.get(i).getCantidad(), i, 4);
            this.model.setValueAt(listaProducto.get(i).getPreUnitario(), i, 5);
            this.model.setValueAt(listaProducto.get(i).getSubTotal(), i, 6);
            this.model.setValueAt(listaProducto.get(i).getDescuento(), i, 7);
            this.model.setValueAt(listaProducto.get(i).getIgv(), i, 8);
            this.model.setValueAt(listaProducto.get(i).getTotalpagar(), i, 9);
        }

        //Añadir al JTable
        jtbVenta.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboxNombre = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        btnAñadirProducto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboxVariante = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboxIphone = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbVenta = new javax.swing.JTable();
        btnBoleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar venta");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caseu.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VENTAS");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Información de la venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cliente");

        cboxCliente.setBackground(new java.awt.Color(255, 255, 255));
        cboxCliente.setForeground(new java.awt.Color(0, 0, 0));
        cboxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:" }));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo case:");

        cboxNombre.setBackground(new java.awt.Color(255, 255, 255));
        cboxNombre.setForeground(new java.awt.Color(0, 0, 0));
        cboxNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione case:" }));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad");

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));

        btnAñadirProducto.setBackground(new java.awt.Color(0, 102, 255));
        btnAñadirProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirProducto.setText("Añadir Producto");
        btnAñadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProductoActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Variante:");

        cboxVariante.setBackground(new java.awt.Color(255, 255, 255));
        cboxVariante.setForeground(new java.awt.Color(0, 0, 0));
        cboxVariante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione variante:" }));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Iphone:");

        cboxIphone.setBackground(new java.awt.Color(255, 255, 255));
        cboxIphone.setForeground(new java.awt.Color(0, 0, 0));
        cboxIphone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iPhone" }));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Datos del producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btnAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cboxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cboxNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxVariante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxIphone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxVariante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addComponent(cboxIphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Subtotal:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Descuento:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("IGV:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Total a pagar:");

        txtSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubtotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(0, 0, 0));
        txtSubtotal.setEnabled(false);

        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 0, 0));
        txtDescuento.setEnabled(false);

        txtIgv.setBackground(new java.awt.Color(255, 255, 255));
        txtIgv.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtIgv.setForeground(new java.awt.Color(0, 0, 0));
        txtIgv.setEnabled(false);

        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 0));
        txtTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txtSubtotal)
                    .addComponent(txtDescuento)
                    .addComponent(txtIgv))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbVenta.setBackground(new java.awt.Color(255, 255, 255));
        jtbVenta.setForeground(new java.awt.Color(0, 0, 0));
        jtbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbVenta);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 220));

        btnBoleta.setBackground(new java.awt.Color(255, 255, 0));
        btnBoleta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBoleta.setForeground(new java.awt.Color(0, 0, 0));
        btnBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        btnBoleta.setText("Registrar Venta");
        btnBoleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBoleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnBoleta)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBoleta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cliente = txtBuscar.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "SELECT apellido, nombre FROM cliente WHERE dni = '" + cliente + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                cboxCliente.setSelectedItem(rs.getString("apellido") + " " + rs.getString("nombre"));
            } else {
                cboxCliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "DNI del cliente es incorrecto o no fue encontrada");
            }
            txtBuscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente " + e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAñadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProductoActionPerformed

        String combo = this.cboxNombre.getSelectedItem().toString();
        //Validar seleccion de producto
        if (combo.equalsIgnoreCase("Seleccione case:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            if (!txtCantidad.getText().isEmpty()) {
                boolean validacion = validar(txtCantidad.getText());
                if (validacion == true) {
                    //Validar cantidad mayor a 0
                    if (Integer.parseInt(txtCantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txtCantidad.getText());
                        //Metodo para datos del producto
                        this.DatosProducto();
                        //Cantidad de producto no sea mayor a la BD
                        if (cantidad <= cantidadBBDD) {
                            subtotal = preUnitario * cantidad;
                            totalPagar = subtotal + igv + descuento;

                            //Redondeando a decimales
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            igv = (double) Math.round(igv * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            //Se crea nuevo producto
                            producto = new DetalleVenta(auxIdDetalle, 1, idProducto, nombre, variante, iphone, Integer.parseInt(txtCantidad.getText()), preUnitario, subtotal, descuento, igv, totalPagar);
                            //Añadir a la Lista
                            listaProducto.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto agregado");
                            auxIdDetalle++;
                            txtCantidad.setText("");//Limpiar el campo
                            this.CargarComboProductos();
                            this.CalcularTotalPagar();

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el Stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error de cantidad, ingrese un monto mayor a 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Solo se permiten caracteres numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos");
            }
        }
        this.listaTablaProducto();
    }//GEN-LAST:event_btnAñadirProductoActionPerformed

    int idArrayList = 0;
    private void jtbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbVentaMouseClicked
        int fila = jtbVenta.rowAtPoint(evt.getPoint());
        int columna = 0;

        if (fila > -1) {
            idArrayList = (int) model.getValueAt(fila, columna);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el producto?");
        //Opciones: si = 0 y no = 1; cancelar=2; close = -1
        switch (opcion) {
            case 0:
                listaProducto.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProducto();
                break;
            case 1: //No desea eliminar
                break;
            default: //Si preciona cancel (2) o close (-1)
                break;
        }
    }//GEN-LAST:event_jtbVentaMouseClicked

    private void btnBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletaActionPerformed
        Venta vt = new Venta();
        DetalleVenta dt = new DetalleVenta();
        Ctrl_RegistrarVenta ct = new Ctrl_RegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!cboxCliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProducto.size() > 0) {
                //Metodo para obetener el ID del cliente
                this.ObtenerIdCliente();
                //Registrar Venta
                vt.setIdVenta(0);
                vt.setIdCliente(idCliente);
                vt.setValorPagar(Double.parseDouble(txtTotal.getText()));
                vt.setFechaVenta(fechaActual);

                if (ct.guardar(vt)) {
                    JOptionPane.showMessageDialog(null, "Venta registrada");
                    //Generar boleta
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosCliente(idCliente);
                    pdf.generarBoletaPDF();

                    //Guardar detalle
                    for (DetalleVenta elemento : listaProducto) {
                        dt.setIdDetalle(0);
                        dt.setIdVenta(0);
                        dt.setIdproducto(elemento.getIdproducto());
                        dt.setCantidad(elemento.getCantidad());
                        dt.setPreUnitario(elemento.getPreUnitario());
                        dt.setSubTotal(elemento.getSubTotal());
                        dt.setDescuento(elemento.getDescuento());
                        dt.setIgv(elemento.getIgv());
                        dt.setTotalpagar(elemento.getTotalpagar());

                        if (ct.guardarDetalle(dt)) {
                            //System.out.println("Detalle de venta registrada");

                            txtSubtotal.setText("0.0");
                            txtDescuento.setText("0.0");
                            txtIgv.setText("0.0");
                            txtTotal.setText("0.0");
                            auxIdDetalle = 1;
                            this.CargarComboClientes();
                            this.RestarStockProductos(elemento.getIdproducto(), elemento.getCantidad());
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar detalle venta");
                        }
                    }
                    //Vaciando la lista
                    listaProducto.clear();
                    listaTablaProducto();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar venta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agregue un producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }
    }//GEN-LAST:event_btnBoletaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDVenta dialog = new JDVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAñadirProducto;
    private javax.swing.JButton btnBoleta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboxCliente;
    private javax.swing.JComboBox<String> cboxIphone;
    private javax.swing.JComboBox<String> cboxNombre;
    private javax.swing.JComboBox<String> cboxVariante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtbVenta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    //Metodo para cargar los clientes en jComboBox
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM cliente";
        Statement st;
        ResultSet rs;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            cboxCliente.removeAllItems();
            cboxCliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                cboxCliente.addItem(rs.getString("apellido") + " " + rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar cliente " + e);
        }
    }

    //Metodo para cargar los productos en jComboBox
    private void CargarComboProductos() {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM producto";
        Statement st;
        ResultSet rs;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            cboxNombre.removeAllItems();
            cboxNombre.addItem("Seleccione case:");
            cboxVariante.removeAllItems();
            cboxVariante.addItem("Seleccione variante:");
            cboxIphone.removeAllItems();
            cboxIphone.addItem("Seleccione iPhone:");
            while (rs.next()) {
                cboxNombre.addItem(rs.getString("nombre"));
                cboxVariante.addItem(rs.getString("variante"));
                cboxIphone.addItem(rs.getString("iphone"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar producto " + e);
        }
    }

    //Metodo para validar que no se ingresen caracteres no numericos
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Metodo para mostrar los datos del producto
    private void DatosProducto() {
        try {
            String sql = "SELECT * FROM producto WHERE nombre = '" + this.cboxNombre.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            ResultSet rs;

            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                variante = rs.getString("variante");
                iphone = rs.getString("iphone");
                cantidadBBDD = rs.getInt("stock");
                preUnitario = rs.getDouble("precio");
                this.CalcularIgv(preUnitario);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto " + e);
        }
    }

    private double CalcularIgv(double precio) {
        igv = (precio * cantidad) * 0.18;
        return igv;
    }

    //Metodo para calcular el Total a pagar de todos los productos agregados a la Tabla
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        igvGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProducto) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            igvGeneral += elemento.getIgv();
            totalPagarGeneral += elemento.getTotalpagar();
        }
        //Redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        igvGeneral = (double) Math.round(igvGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //Enviar datos a la vista del JDialog Venta
        txtSubtotal.setText(String.valueOf(subtotalGeneral));
        txtDescuento.setText(String.valueOf(descuentoGeneral));
        txtIgv.setText(String.valueOf(igvGeneral));
        txtTotal.setText(String.valueOf(totalPagarGeneral));
    }

    private void ObtenerIdCliente() {
        try {
            String sql = "SELECT * FROM cliente WHERE CONCAT(apellido,' ',nombre) = '" + this.cboxCliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el Id del cliente " + e);
        }
    }

    //Metodo para restar la cantidad o stock de los productos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductoBD = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT idProducto, stock FROM producto WHERE idProducto = '" + idProducto + "' ";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                cantidadProductoBD = rs.getInt("stock");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock 1" + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("UPDATE producto SET stock=? WHERE idProducto = '" + idProducto + "' ");
            int nuevoStock = cantidadProductoBD - cantidad;
            ps.setInt(1, nuevoStock);
            if (ps.executeUpdate() > 0) {
                System.out.println("Actualizado");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock 2" + e);
        }
    }

    //Tamaño del ancho de las columnas y filarlos
    private void FijarColumna() {

        jtbVenta.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtbVenta.getColumnModel().getColumn(0).setResizable(false);
        jtbVenta.getColumnModel().getColumn(1).setPreferredWidth(25);
        jtbVenta.getColumnModel().getColumn(1).setResizable(false);
        jtbVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtbVenta.getColumnModel().getColumn(2).setResizable(false);
        jtbVenta.getColumnModel().getColumn(3).setPreferredWidth(80);
        jtbVenta.getColumnModel().getColumn(3).setResizable(false);
        jtbVenta.getColumnModel().getColumn(4).setPreferredWidth(30);
        jtbVenta.getColumnModel().getColumn(4).setResizable(false);
        jtbVenta.getColumnModel().getColumn(5).setPreferredWidth(20);
        jtbVenta.getColumnModel().getColumn(5).setResizable(false);
        jtbVenta.getColumnModel().getColumn(6).setPreferredWidth(10);
        jtbVenta.getColumnModel().getColumn(6).setResizable(false);
        jtbVenta.getColumnModel().getColumn(7).setPreferredWidth(10);
        jtbVenta.getColumnModel().getColumn(7).setResizable(false);
        jtbVenta.getColumnModel().getColumn(8).setPreferredWidth(10);
        jtbVenta.getColumnModel().getColumn(8).setResizable(false);
        jtbVenta.getColumnModel().getColumn(9).setPreferredWidth(20);
        jtbVenta.getColumnModel().getColumn(9).setResizable(false);

        jtbVenta.setRowHeight(20);
    }
}
