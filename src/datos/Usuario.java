
package datos;

public class Usuario {
    
    private int idUsuario;
    private String apellido;
    private String nombre;
    private String dni;
    private String celular;
    private String direccion;
    private String categoria;
    private String usuario;
    private String clave;

    public Usuario() {
    }

    public Usuario(int idUsuario, String apellido, String nombre, String dni, String celular, String direccion, String categoria, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
        this.categoria = categoria;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
