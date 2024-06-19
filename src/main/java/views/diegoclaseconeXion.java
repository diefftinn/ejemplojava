
package views;

import Controller.CategoriaController;
import Controller.ProductoController;


public class diegoclaseconeXion {
    public static void main(String[] args) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
    }
    
}
