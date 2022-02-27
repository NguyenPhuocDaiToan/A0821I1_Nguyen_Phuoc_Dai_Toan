package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final String GET_LIST_PRODUCT = "SELECT * FROM PRODUCT";
    private final String ADD_NEW_PRODUCT = "INSERT INTO PRODUCT(name, price, quantity, color, id_category)"
                                            + "VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_PRODUCT = "UPDATE PRODUCT SET name = ?, price = ?, quantity = ?, color = ?"
                                            + ", id_category = ? WHERE id = ?";
    private final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE id = ?";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE id = ?";
    private final String FIND_PRODUCT_BY_NAME = "SELECT * FROM PRODUCT WHERE name like ?";


    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_PRODUCT); )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int id_category = resultSet.getInt("id_category");
                products.add(new Product(id, name, price, quantity, color, id_category));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public Product selectProductByID(int id) {
        Product product = null;
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID))
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String color = resultSet.getString("color");
                String idCategory = resultSet.getString("id_category");

                product = new Product(id, name, price, quantity, color, Integer.parseInt(idCategory));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_NAME);)
        {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameProduct = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int id_category = rs.getInt("id_category");
                products.add(new Product(id, nameProduct, price, quantity, color, id_category));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public void add(Product product) {
        try (Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PRODUCT))
        {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getId_category());
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Product product) {
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT))
        {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getId_category());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
