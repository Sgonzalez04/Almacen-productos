import java.util.HashMap;
import java.util.Map;

public class AlmacenProductos {
    private Map<Integer, Producto> inventario;
    private Map<Integer, String> categorias;

    public AlmacenProductos() {
        inventario = new HashMap<>();
        categorias = new HashMap<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        categorias.put(1, "Computadores");
        categorias.put(2, "Celulares");
        categorias.put(3, "Electrodomésticos");
        categorias.put(4, "TV");
        categorias.put(5, "Accesorios");
        categorias.put(6, "Videojuegos");
        categorias.put(7, "Audio y video");
    }

    public void agregarProducto(int referencia, String nombre, double precio, int cantidad, int categoria) {
        if (!inventario.containsKey(referencia) && categorias.containsKey(categoria)) {
            Producto producto = new Producto(nombre, precio, referencia, cantidad, categoria);
            inventario.put(referencia, producto);
            System.out.println("Producto agregado con éxito.");
        } else {
            System.out.println("Error: Producto con la misma referencia o categoría no válida.");
        }
    }

    public void eliminarProducto(int referencia) {
        if (inventario.containsKey(referencia)) {
            inventario.remove(referencia);
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Error: Producto no encontrado.");
        }
    }

    public void agregarCategoria(int codigo, String nombre) {
        if (!categorias.containsKey(codigo)) {
            categorias.put(codigo, nombre);
            System.out.println("Categoría agregada con éxito.");
        } else {
            System.out.println("Error: Categoría ya existente.");
        }
    }

    public void eliminarCategoria(int codigo) {
        if (categorias.containsKey(codigo)) {
            categorias.remove(codigo);
            System.out.println("Categoría eliminada con éxito.");
        } else {
            System.out.println("Error: Categoría no encontrada.");
        }
    }

    public void mostrarInventarioPorCategoria(int categoria) {
        System.out.println("Inventario de la categoría " + categorias.get(categoria) + ":");
        for (Producto producto : inventario.values()) {
            if (producto.getCategoria() == categoria) {
                System.out.println(producto);
            }
        }
    }

    public void mostrarCategorias() {
        System.out.println("Categorías disponibles:");
        for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
