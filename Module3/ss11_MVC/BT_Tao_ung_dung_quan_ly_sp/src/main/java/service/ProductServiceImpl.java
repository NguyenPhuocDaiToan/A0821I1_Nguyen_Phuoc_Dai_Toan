package service;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    static List<Product> products = new ArrayList<>();

    static int findId() {
        return products.size() == 0 ? 1 : products.get(products.size() - 1).getId() + 1;
    }
    static {
        products.add(new Product(findId(), "Oppo Reno 5", 5555, "New 55%", "Oppo"));
        products.add(new Product(findId(), "Oppo Reno 6", 6666, "New 66%", "Oppo"));
        products.add(new Product(findId(), "Oppo Reno 7", 7777, "New 77%", "Oppo"));
        products.add(new Product(findId(), "Oppo Reno 8", 8888, "New 88%", "Oppo"));
        products.add(new Product(findId(), "Iphone 13", 1333, "New 90%", "Apple"));
        products.add(new Product(findId(), "Iphone 12", 1222, "New 100%", "Apple"));
        products.add(new Product(findId(), "SamSung S21", 2111, "New 100%", "SamSung"));
        products.add(new Product(findId(), "SamSung Galaxy Z Fold 3", 5000, "New 100%", "SamSung"));
        products.add(new Product(findId(), "Xiaomi 11T", 1090, "New 80%", "Xiaomi"));
        products.add(new Product(findId(), "Xiaomi 11T Pro 5G", 2090, "New 80%", "Xiaomi"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(findId());
        products.add(product);
    }

    @Override
    public void remove(int id) {
        products.removeIf(e->e.getId() == id);
    }

    @Override
    public void update(int id, Product product) {
        int size = products.size();
        for(int i = 0; i < size; i++) {
            if(products.get(i).getId() == id)
                products.set(i, product);
        }
    }

    @Override
    public Product findById(int id) {
        int size = products.size();
        for(int i = 0; i < size; i++) {
            if(products.get(i).getId() == id)
                return products.get(i);
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return products.stream().filter(e->e.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }
}
