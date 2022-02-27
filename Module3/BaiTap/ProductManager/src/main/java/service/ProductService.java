package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public List<Product> getAll() {
        return  productDAO.getAll();
    }
    public Product selectProductByID(int id) {
        return productDAO.selectProductByID(id);
    }

    public List<Product> findByName(String name) {
        return productDAO.findByName(name);
    }

    public void add(Product product) {
        productDAO.add(product);
    }

    public void update(Product product) {
        productDAO.update(product);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }
}
