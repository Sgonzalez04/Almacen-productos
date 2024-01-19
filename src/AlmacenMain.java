import java.util.InputMismatchException;
import java.util.Scanner;

public class AlmacenMain {
    public static void main(String[] args) {
        AlmacenProductos almacen = new AlmacenProductos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = OpcionUsuario(scanner);

                switch (opcion) {
                    case 1:
                        agregarProducto(almacen, scanner);
                        break;
                    case 2:
                        eliminarProducto(almacen, scanner);
                        break;
                    case 3:
                        agregarCategoria(almacen, scanner);
                        break;
                    case 4:
                        eliminarCategoria(almacen, scanner);
                        break;
                    case 5:
                        mostrarInventarioPorCategoria(almacen, scanner);
                        break;
                    case 6:
                        mostrarCategorias(almacen);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {//e = errores escritura
                System.out.println("Error: Ingresa un valor válido.");
                scanner.nextLine();
                opcion = -1; // Forzar la repetición del bucle
            } catch (Exception e) { // cualquier erro exepto e
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Eliminar Producto");
        System.out.println("3. Agregar Categoría");
        System.out.println("4. Eliminar Categoría");
        System.out.println("5. Mostrar Inventario por Categoría");
        System.out.println("6. Mostrar Categorías");
        System.out.println("0. Salir");
    }

    private static int OpcionUsuario(Scanner scanner) {
        int opcion;
        System.out.print("Seleccione una opción: ");
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error: Ingresa un número entero.");
        }
        scanner.nextLine(); // Consumir el salto de línea
        return opcion;
    }

    private static void agregarProducto(AlmacenProductos almacen, Scanner scanner) {
        try {
            System.out.print("Ingrese la referencia del producto: ");
            int referencia = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            System.out.print("Ingrese la categoría del producto: ");
            int categoriaProducto = scanner.nextInt();
            almacen.agregarProducto(referencia, nombre, precio, cantidad, categoriaProducto);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa valores válidos.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    private static void eliminarProducto(AlmacenProductos almacen, Scanner scanner) {
        try {
            System.out.print("Ingrese la referencia del producto a eliminar: ");
            int referenciaEliminar = scanner.nextInt();
            almacen.eliminarProducto(referenciaEliminar);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número entero.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    private static void agregarCategoria(AlmacenProductos almacen, Scanner scanner) {
        try {
            System.out.print("Ingrese el código de la categoría: ");
            int codigoCategoria = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nombre de la categoría: ");
            String nombreCategoria = scanner.nextLine();
            almacen.agregarCategoria(codigoCategoria, nombreCategoria);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número entero.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    private static void eliminarCategoria(AlmacenProductos almacen, Scanner scanner) {
        try {
            System.out.print("Ingrese el código de la categoría a eliminar: ");
            int codigoEliminar = scanner.nextInt();
            almacen.eliminarCategoria(codigoEliminar);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número entero.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    private static void mostrarInventarioPorCategoria(AlmacenProductos almacen, Scanner scanner) {
        try {
            System.out.print("Ingrese el código de la categoría para mostrar el inventario: ");
            int categoriaMostrar = scanner.nextInt();
            almacen.mostrarInventarioPorCategoria(categoriaMostrar);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número entero.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    private static void mostrarCategorias(AlmacenProductos almacen) {
        almacen.mostrarCategorias();
    }
}
