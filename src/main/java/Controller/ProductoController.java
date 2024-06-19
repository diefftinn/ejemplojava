
package Controller;

import views.ProductoView;
import  dao.ProductoDAO;
import model.Producto;
import views.ProductoView;
import java.util.List;
import java.util.Scanner;

public class ProductoController {
    private ProductoDAO productoDAO;
    private Scanner scanner;

    public ProductoController() {
        productoDAO = new ProductoDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    leerProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("\nIngrese el ID de la categoria que desea actualizar: ");
        int categoriaId = scanner.nextInt();
        Producto producto = new Producto(0, nombre, precio,categoriaId);
        productoDAO.crearProducto(producto);
        ProductoView.mostrarMensaje("Producto creado exitosamente.");
    }

    private void leerProductos() {
        List<Producto> productos = (List<Producto>) productoDAO.leerProductos();
        ProductoView.mostrarProductos(productos);
    }

    private void actualizarProducto() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("\nIngrese el ID de la categoria que desea actualizar: ");
        int categoriaId = scanner.nextInt();
        Producto producto = new Producto(id, nuevoNombre, nuevoPrecio, categoriaId);
        productoDAO.actualizarProducto(producto);
        ProductoView.mostrarMensaje("Producto actualizado exitosamente.");
    }

    private void eliminarProducto() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea eliminar: ");
        int id = scanner.nextInt();
        productoDAO.eliminarProducto(id);
        ProductoView.mostrarMensaje("Producto eliminado exitosamente.");
    } 

}

