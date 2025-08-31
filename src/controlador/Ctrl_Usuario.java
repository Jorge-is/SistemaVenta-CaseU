package controlador;

import datos.Usuario;
import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Ctrl_Usuario {
    
    Connection cn;
    PreparedStatement ps;

    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario, clave FROM usuario WHERE usuario = '" + objeto.getUsuario() + "' AND clave = '" + objeto.getClave() + "' ";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta;
    }
    
    //Metodo para crear nuevos usuarios 
    public boolean Crear(Usuario objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            
            ps.setInt(1, 0);
            ps.setString(2,objeto.getApellido());
            ps.setString(3,objeto.getNombre());
            ps.setString(4,objeto.getDni());
            ps.setString(5,objeto.getCelular());
            ps.setString(6,objeto.getDireccion());
            ps.setString(7,objeto.getCategoria());
            ps.setString(8,objeto.getUsuario());
            ps.setString(9,objeto.getClave());
                       
            if (ps.executeUpdate()>0) {
                respuesta = true;
            }
            cn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario " + e);
        }
        return respuesta;
    }
    
    //Metodo para verificar si el usuario ya existe
    public boolean existeUsuario(String usuario){
        boolean respuesta = false;
        
        String sql = "SELECT usuario FROM usuario WHERE usuario = '" + usuario + "'";
        Statement st;
        
        try {
            cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }            
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario "+ e);
        }
        return respuesta;       
    }
    
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        cn = Conexion.conectar();
        String sql = "UPDATE usuario SET apellidos=?,nombres=?,celular=?,categoria=?,usuario=?,clave=? WHERE idUsuario ='" + idUsuario + "'";
        
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, objeto.getApellido());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getCelular());
            ps.setString(4, objeto.getCategoria());
            ps.setString(5, objeto.getUsuario());
            ps.setString(6, objeto.getClave());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();           
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario " + e);
        }
        return respuesta;
    }
    
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        cn = Conexion.conectar();
        String sql = "DELETE FROM usuario WHERE idUsuario ='" + idUsuario + "'";
        try {
            ps = cn.prepareStatement(sql);            
            ps.executeUpdate();

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();           
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario " + e);
        }
        return respuesta;
    }   
}
