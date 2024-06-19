
package views;

import model.Categoria;
import java.util.List;

public class CategoriaView {
    public static void mostrarCategorias(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            System.out.println("\n--- Lista de Categorías ---");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getId() + ". " + categoria.getNombre());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}