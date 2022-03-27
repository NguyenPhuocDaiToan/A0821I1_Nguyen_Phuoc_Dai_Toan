package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private static final List<Product> products;

    static {

        products = new ArrayList<>();
        products.add(new Product(1, "Laptop nitro 1", 199, "100%", "Acer"));
        products.add(new Product(2, "Laptop nitro 2", 299, "100%", "Acer"));
        products.add(new Product(3, "Laptop nitro 3", 399, "100%", "Acer"));
        products.add(new Product(4, "Laptop nitro 4", 499, "100%", "Acer"));
        products.add(new Product(5, "Laptop nitro 5", 599, "100%", "Acer"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public boolean save(Product product) {
        int id = (products.size() == 0) ? 1: (products.get(products.size() - 1).getId() + 1);
        try {
            if(product.getId() == 0) {
                product.setId(id);
                products.add(product);
            }
            else {
                int size = products.size();
                for (int i = 0; i < size; i++) {
                    if(products.get(i).getId() == product.getId())
                    {
                        products.set(i, product);
                        break;
                    }
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            int size = products.size();
            for (int i = 0; i < size; i++) {
                if (products.get(i).getId() == id) {
                    products.remove(i);
                    break;
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }
}
