package ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.ArrayList;

import ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.Product;

import java.util.*;

public class ProductService {
    private static ArrayList<Product> listProducts = new ArrayList<>();

    public static void save(Product product) {
        if(product.getId() == 0) {
            product.setId(listProducts.size() + 1);
            listProducts.add(product);
        }
        else {
            int size = listProducts.size();
            for(int i = 0; i < size; i++) {
                if(listProducts.get(i).getId() == product.getId()) {
                    listProducts.set(i, product);
                    break;
                }
            }
        }
    }

    public static void delete(int id) {
        int size = listProducts.size();
        for(int i = 0; i < size; i++) {
            if(listProducts.get(i).getId() == id) {
                listProducts.remove(i);
                break;
            }
        }
    }

    static List<Product> getAll() {
        return listProducts;
    }

    static List<Product> search(String name) {
        int size = listProducts.size();
        List<Product> res = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(listProducts.get(i).getName().contains(name)) {
                res.add(listProducts.get(i));
            }
        }
        return res;
    }
    public static void sort(boolean isASC) {
        listProducts.sort(isASC ? Comparator.comparing(Product::getPrice) : Comparator.comparing(Product::getPrice).reversed());
    }
}
