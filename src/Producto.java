public class Producto {
    private String nombre;
    private double precio;
    private int referencia;
    private int cantidad;
    private int categoria;

    public Producto(String nombre, double precio, int referencia, int cantidad, int categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public int getReferencia() {
        return referencia;
    }

    public int getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Referencia: " + referencia + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }
}
