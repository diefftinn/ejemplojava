
package dao;

import com.configs.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class ProductoDAO {
    private Connection conexion;
    private ConexionDB conexionDB;

    public ProductoDAO() { 
        conexionDB = new ConexionDB();
        conexion = conexionDB.getConexion();
    }

    public void crearProducto(Producto producto){
        String sql = "INSERT INTO productos (nombre, precio, categoria_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoriaId());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                int categoriaId = resultSet.getInt("categoria_id");
                Producto producto = new Producto(id, nombre, precio, categoriaId);
                productos.add(producto);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoriaID = ? WHERE ID = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoriaId());
            statement.setInt(4, producto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() {
        conexionDB.closeConexion(conexion);
    } 
}

