
package datos;

public class Venta {
    
    private int idVenta;
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;

    public Venta() {
    }

    public Venta(int idVenta, int idCliente, double valorPagar, String fechaVenta) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + '}';
    }
}
