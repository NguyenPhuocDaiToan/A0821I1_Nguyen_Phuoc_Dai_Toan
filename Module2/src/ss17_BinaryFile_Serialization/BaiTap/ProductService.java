package ss17_BinaryFile_Serialization.BaiTap;

import ss7_Abstract_Interface.BaiTap.Colorable.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements Serializable{
    public static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();


    public static void add() {
        products = ReadAndWriteFile.ReadFile();
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Input price: ");
        int price = Integer.parseInt(scanner.nextLine());
        int id = products.size() + 1;
        Product product = new Product(id, name, manufacturer, price);
        products.add(product);
    }
    public static List<Product> getAll() {
        return products;
    }
    public static List<Product> find(String name) {
        int size = products.size();
        List<Product> res = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(products.get(i).getName().contains(name)) {
                res.add(products.get(i));
            }
        }
        return res;
    }

}
