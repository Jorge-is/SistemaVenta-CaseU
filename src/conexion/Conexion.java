package conexion;

import java.sql.*;

public class Conexion {

    public static Connection conectar() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventa", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
        return null;
    }

//    public String driver = "con.mysql.cj.jdbc.Driver";
//    public String cadena = "jdbc:mysql://localhost:3306/sistemaventa";
//    public String usuario = "root";
//    public String clave = "";
//    public Connection cn;
//
//    public Connection conectar() {
//        try {
//            Class.forName(driver);
//            cn = DriverManager.getConnection(cadena, usuario, clave);
//        } catch (ClassNotFoundException e1) {
//            System.out.println("Error en el driver " + e1);
//        } catch (SQLException e2) {
//            System.out.println("Error en la conexion " + e2);
//        }
//        return cn;
//    }
}
