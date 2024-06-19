
package dao;

import com.configs.ConexionDB;
import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {
  private Connection conexion;
    private ConexionDB conexionDB;
    private int categoriaID;

    public CategoriaDAO() {
        conexionDB = new ConexionDB();
        conexion = conexionDB.getConexion();
    }

    
    public void crearCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Categoria> leerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("categoriaID");
                String nombre = resultSet.getString("nombre");
                Categoria categoria = new Categoria(id, nombre);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return categorias;
    }

    public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre = ? WHERE categoriaID = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.setInt(2, categoria.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categoria WHERE categoriaID = ?";
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

    public List<Categoria> leerCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}