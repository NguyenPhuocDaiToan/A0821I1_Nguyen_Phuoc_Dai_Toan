package ss17_BinaryFile_Serialization.BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            displayMenu();
            int choice;
            String name;
            do {
                System.out.print("Input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice < 1 || choice > 4)    System.out.println("Your choice is invalid.\nPlease re-enter your choice.");
            } while (choice < 1 || choice > 4);

            switch (choice) {
                case 1:
                    ProductService.add();
                    break;
                case 2:
                    name = scanner.nextLine();
                    ProductService.find(name).forEach(System.out::println);
                    break;
                case 3:
                    ProductService.getAll().forEach(System.out::println);
                    break;
                default:
                    ReadAndWriteFile.WriteFile(ProductService.getAll());
                    return;
            }
        }
    }
    private static void displayMenu() {
        System.out.println("\t1. Add new product");
        System.out.println("\t2. Find product");
        System.out.println("\t3. Display list products");
        System.out.println("\t4. Exit");
    }
}
