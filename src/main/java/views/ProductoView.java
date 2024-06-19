
package views;

import model.Producto;
import java.util.List;

public class ProductoView {
    public static void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Producto producto : productos) {
                System.out.println(producto.getId() + ". " + producto.getNombre() + " - Precio: " + producto.getPrecio());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}