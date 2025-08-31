
package datos;

public class Producto {
    
    private int idproducto;
    private String nombre;
    private String variante;
    private String iphone;
    private double precio;
    private int stock;
    private String descripcion;

    public Producto() {
    }

    public Producto(int idproducto, String nombre, String variante, String iphone, double precio, int stock, String descripcion) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.variante = variante;
        this.iphone = iphone;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    
}
