package controlador;

import conexion.Conexion;
import datos.DetalleVenta;
import java.sql.*;
import datos.Venta;
import javax.swing.JOptionPane;

public class Ctrl_RegistrarVenta {

    Connection cn;
    PreparedStatement ps;

    //Variables para el último ID de la venta
    public static int idVentaRegistrada;
    java.math.BigDecimal iDColVar;

    //Metodo para guardar las Ventas
    public boolean guardar(Venta objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO venta VALUES(?,?,?,?)";

        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Obtener el ultimo ID que se registre

            ps.setInt(1, 0); //ID
            ps.setInt(2, objeto.getIdCliente());
            ps.setDouble(3, objeto.getValorPagar());
            ps.setString(4, objeto.getFechaVenta());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idVentaRegistrada = iDColVar.intValue();
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar venta " + e);
        }
        return respuesta;
    }

    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO detalle_venta VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);

            ps.setInt(1, 0); //ID
            ps.setInt(2, idVentaRegistrada);
            ps.setInt(3, objeto.getIdproducto());
            ps.setInt(4, objeto.getCantidad());
            ps.setDouble(5, objeto.getPreUnitario());
            ps.setDouble(6, objeto.getSubTotal());
            ps.setDouble(7, objeto.getDescuento());
            ps.setDouble(8, objeto.getIgv());
            ps.setDouble(9, objeto.getTotalpagar());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar detalle venta" + e);
        }
        return respuesta;
    }

}
