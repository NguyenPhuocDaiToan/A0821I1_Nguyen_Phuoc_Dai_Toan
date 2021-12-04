package ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.LinkedList;

import ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    private LinkedList<Product> listProducts = new LinkedList<>();
    public ProductManager() {

    }
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        if(listProducts.size() == 0)    product.setId(1);
        else product.setId(listProducts.size() + 1);
        System.out.print("Nhập tên: ");
        product.setName(scanner.nextLine());
        System.out.print("Nhập giá tiền: ");
        product.setPrice(Float.parseFloat(scanner.nextLine()));
        listProducts.add(product);
    }
    public boolean deleteProduct(int id) {
        int size = listProducts.size();
        for(int i = 0; i < size; i++) {
            if(listProducts.get(i).getId() == id) {
                listProducts.remove(i);
                return true;
            }
        }
        return false;
    }
    public void displayProducts() {
        System.out.println("Danh sách sản phẩm là: ");
        for(Product product: listProducts) {
            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice());
        }
    }
    public int findProduct(String name) {
        int size = listProducts.size();
        for(int i = 0; i < size; i++) {
            if(listProducts.get(i).getName().equals(name)) {
                System.out.println("Sản phẩm: " + name + "có id là: " + listProducts.get(i).getId());
                return i;
            }
        }
        return -1;

    }
    public void sortAscendingByPrice() {
        listProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice())
                    return 1;
                if (o1.getPrice() < o2.getPrice())
                    return -1;
                return 0;
            }
        });
    }
}
