package ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.ArrayList;

import Furama_Resort.utils.CommonUtil;
import Furama_Resort.views.*;
import ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.Product;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }
    static void displayMenu() {
        System.out.println("1. Add new product.");
        System.out.println("2. Edit a product.");
        System.out.println("3. Delete a product.");
        System.out.println("4. Display list product.");
        System.out.println("5. Search by name");
        System.out.println("6. Sort by price");
        int choice = 0;
        do {
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(CommonUtil.getScanner().nextLine());
            if(choice < 1 || choice > 6) {
                System.out.println("Your input is invalid.");
                System.out.println("Please re-enter choice valid from 1-6.");
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1:
                creat();
                break;
            case 2:
                edit();
                break;
            case 3:
                delete();
                break;
            case 4:
                display();
                break;
            case 5:
                search();
                break;
            case 6:
                sort();
                break;
        }
    }

    private static void creat() {
        inputAndSave(0);
    }

    private static void edit() {
        display();
        System.out.print("Input product id to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        inputAndSave(id);
    }

    private static void delete() {
        display();
        System.out.print("Input product id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        ProductService.delete(id);
        System.out.println("Delete Successfull");
    }

    private static void search() {
        System.out.println("Input product name to search");
        String name = scanner.nextLine();
        ProductService.search(name).forEach(System.out::println);
    }

    private static void sort() {
        System.out.println("Do you want sort by ASC(1) or DESC(0)");
        boolean isASC = Boolean.parseBoolean(scanner.nextLine());
        ProductService.sort(isASC);
    }

    private static void display() {
        ProductService.getAll().forEach(System.out::println);
    }

    private static void inputAndSave(int id) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(name, price);
        ProductService.save(product);
    }

}
