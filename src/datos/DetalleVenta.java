
package datos;

public class DetalleVenta {
    
    private int idDetalle;
    private int idVenta;
    private int idproducto;
    
    private String nombre;
    private String variante;
    private String iphone;
    
    private int cantidad;
    private double preUnitario;
    private double subTotal;
    private double descuento;
    private double igv;
    private double totalpagar;
    
    //Constructor 

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalle, int idVenta, int idproducto, String nombre,String variante, String iphone, int cantidad, double preUnitario, double subTotal, double descuento, double igv, double totalpagar) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.preUnitario = preUnitario;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.igv = igv;
        this.totalpagar = totalpagar;
        
        this.variante = variante;
        this.iphone = iphone;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreUnitario() {
        return preUnitario;
    }

    public void setPreUnitario(double preUnitario) {
        this.preUnitario = preUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalpagar() {
        return totalpagar;
    }

    public void setTotalpagar(double totalpagar) {
        this.totalpagar = totalpagar;
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
    
    
    
    //Metodo toString

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalle=" + idDetalle + ", idVenta=" + idVenta + ", idproducto=" + idproducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", preUnitario=" + preUnitario + ", subTotal=" + subTotal + ", descuento=" + descuento + ", igv=" + igv + ", totalpagar=" + totalpagar + '}';
    }
    
}
