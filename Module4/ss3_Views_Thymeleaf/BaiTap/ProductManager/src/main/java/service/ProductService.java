package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    boolean save(Product product);
    boolean delete(int id);
    Product findById(int id);
    List<Product> searchProductByName(String name);
}
