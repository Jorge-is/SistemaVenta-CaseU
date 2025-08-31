package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Date;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import vista.JDVenta;

public class VentaPDF {

    private String nombreCliente;
    private String dniCliente;
    private String celularCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDF = "";

    //Metodo para obtener datos del cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM cliente WHERE idCliente = '" + idCliente + "'";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("apellido") + " " + rs.getString("nombre");
                dniCliente = rs.getString("dni");
                celularCliente = rs.getString("celular");
                direccionCliente = rs.getString("direccion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente " + e);
        }
    }

    //Metodo para generar boleta de venta
    public void generarBoletaPDF() {
        try {
            //Cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //Cambiar el formato de la fecha de / a _
            String nuevafecha = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    nuevafecha = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDF = "Venta_" + nombreCliente + "_" + nuevafecha + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDF); //Ruta donde se guarda el PDF
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/imagenes/caseupdf.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE); //Agregar una nueva linea
            fecha.add("Boleta: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);//Quitar el borde de la tabla           
            //Tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(ColumnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //Agregar celdas
            encabezado.addCell(img);

            String ruc = "20603810016";
            String nombre = "Case-U";
            String celular = "998122600";
            String direccion = "Av. Ingenieros 290, La Molina";
            String razon = "VAPETECHPERU S.A.C";
            String detalle = "¡Case predeterminados y personalizados!";

            encabezado.addCell("");
            encabezado.addCell("RUC: " + ruc + "\nEmpresa: " + nombre + "\nCelular: " + celular + "\nDireccion: " + direccion + "\nRazón Social: " + razon + "\n"+detalle);
            encabezado.addCell(fecha);
            doc.add(encabezado);

            //Cuerpo
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//Nueva linea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //Datos del cliente
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0); //Quitando los bordes de la tabla cliente

            //Tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Celular: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));

            //Quitando bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            //Agregando celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(dniCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(celularCliente);
            tablaCliente.addCell(direccionCliente);

            //Agregar al documento
            doc.add(tablaCliente);

            //Espacio en blanco
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            
            Paragraph pedido = new Paragraph();
            pedido.add(Chunk.NEWLINE);//Nueva linea
            pedido.add("Datos del pedido: " + "\n\n");
            doc.add(pedido);

            //Agregar los productos
            PdfPTable tablaProducto = new PdfPTable(6); //Era 4 y cambie por 6
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //Tamaño de celda
            float[] ColumnaProducto = new float[]{15f, 15f, 20f, 15f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Variante: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("iPhone: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("P.Unitario: ", negrita));
            PdfPCell producto6 = new PdfPCell(new Phrase("Total: ", negrita));
            //Quitando bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);
            producto6.setBorder(0);
            //Agregar color al encabezado del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //Agregar a la celda de la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            tablaProducto.addCell(producto5);
            tablaProducto.addCell(producto6);

            for (int i = 0; i < JDVenta.jtbVenta.getRowCount(); i++) {
                String producto = JDVenta.jtbVenta.getValueAt(i, 1).toString();
                String variante = JDVenta.jtbVenta.getValueAt(i, 2).toString();
                String iphone= JDVenta.jtbVenta.getValueAt(i, 3).toString();
                String cantidad = JDVenta.jtbVenta.getValueAt(i, 4).toString();
                String precio = JDVenta.jtbVenta.getValueAt(i, 5).toString();
                String total = JDVenta.jtbVenta.getValueAt(i, 9).toString();

                tablaProducto.addCell(producto);
                tablaProducto.addCell(variante);
                tablaProducto.addCell(iphone);
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }
            //Agregar al documento
            doc.add(tablaProducto);
            
            //Total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: S/ " + JDVenta.txtTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por tu compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
            //Cerrando el docuemnto
            doc.close();
            archivo.close();
            
            //Abrir el documento al ser emitido
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en " + e);
        }
    }
}
