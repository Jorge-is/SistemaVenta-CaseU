package controlador;

import datos.Usuario;
import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import util.Seguridad;

public class Ctrl_Usuario {

    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        String sql = "SELECT usuario, clave FROM usuario WHERE usuario = ? AND clave = ?";
        
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
             
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, Seguridad.hashearClave(objeto.getClave()));
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion: " + e.getMessage());
        }
        return respuesta;
    }
    
    //Metodo para crear nuevos usuarios 
    public boolean Crear(Usuario objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO usuario (apellidos, nombres, dni, celular, direccion, categoria, usuario, clave) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, objeto.getApellido());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getDni());
            ps.setString(4, objeto.getCelular());
            ps.setString(5, objeto.getDireccion());
            ps.setString(6, objeto.getCategoria());
            ps.setString(7, objeto.getUsuario());
            ps.setString(8, Seguridad.hashearClave(objeto.getClave()));
                       
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        }
        return respuesta;
    }
    
    //Metodo para verificar si el usuario ya existe
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "SELECT usuario FROM usuario WHERE usuario = ?";
        
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
             
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }
        return respuesta;       
    }
    
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        String sql = "UPDATE usuario SET apellidos=?, nombres=?, celular=?, categoria=?, usuario=?, clave=? WHERE idUsuario = ?";
        
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, objeto.getApellido());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getCelular());
            ps.setString(4, objeto.getCategoria());
            ps.setString(5, objeto.getUsuario());
            
            // Si la clave viene vacia, no la actualizar pero si la mandan la encriptamos. 
            // Para simplificar, asumimos que siempre la mandan:
            ps.setString(6, Seguridad.hashearClave(objeto.getClave()));
            ps.setInt(7, idUsuario);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
        return respuesta;
    }
    
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        
        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
             
            ps.setInt(1, idUsuario);
            
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
        return respuesta;
    }   
}
