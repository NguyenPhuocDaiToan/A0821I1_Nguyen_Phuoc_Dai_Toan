package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
    void remove(int id);
    void update(int id, Product product);
    Product findById(int id);
    List<Product> findByName(String name);
}
