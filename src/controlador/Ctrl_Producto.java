package controlador;

import conexion.Conexion;
import datos.Producto;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Producto {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO producto (idProducto, nombre, variante, iphone, precio, cantidad, descripcion) VALUES (?,?,?,?,?,?,?)";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);

            ps.setInt(1, 0);
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getVariante());
            ps.setString(4, objeto.getIphone());
            ps.setDouble(5, objeto.getPrecio());
            ps.setInt(6, objeto.getStock());
            ps.setString(7, objeto.getDescripcion());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        String sql = "UPDATE producto SET nombre=?,variante=?,iphone=?,precio=?,cantidad=?,descripcion=? WHERE idProducto='" + idProducto + "'";
        cn = Conexion.conectar();
        
        try {
            ps = cn.prepareStatement(sql);

            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getVariante());
            ps.setString(3, objeto.getIphone());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getStock());
            ps.setString(6, objeto.getDescripcion());
            
            if (ps.executeUpdate()> 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto " + e);
        }
        return respuesta;
    }

    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        cn = Conexion.conectar();
        String sql = "DELETE FROM producto WHERE idProducto ='" + idProducto + "'";
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto " + e);
        }
        return respuesta;
    }

    public boolean buscarProducto(Producto objeto) {
        boolean respuesta = false;
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ps.setInt(1, 0);
                ps.setString(2, objeto.getNombre());
                ps.setString(3, objeto.getVariante());
                ps.setString(4, objeto.getIphone());
                ps.setDouble(5, objeto.getPrecio());
                ps.setInt(6, objeto.getStock());
                ps.setString(7, objeto.getDescripcion());
            }

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto " + e);
        }
        return respuesta;
    }
    
    //Metodo para filtrar producto con el nombre
    public DefaultTableModel buscar(String buscar) {
        cn = Conexion.conectar();
        DefaultTableModel model;
        String[] titulos = {"ID","Nombre", "Variante", "iPhone", "Precio", "Cantidad", "Descripcion"};

        String[] registro = new String[7];
        model = new DefaultTableModel(null, titulos);

        //totalregistros = 0;

        String sql = "SELECT * FROM producto WHERE nombre LIKE '%" + buscar + "%' ORDER BY idProducto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("variante");
                registro[3] = rs.getString("iphone");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("descripcion");

                //totalregistros += 1;
                model.addRow(registro);
            }
            cn.close();
            return model;
        } catch (SQLException e) {
            System.out.println("Error al mostrar producto " + e);
            return null;
        }
    }    
}
