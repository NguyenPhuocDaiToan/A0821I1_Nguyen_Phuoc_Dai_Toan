package view;

import exception.NotFoundProductException;
import model.GenuineProduct;
import model.HandedProduct;
import service.GenuineProductService;
import service.HandedProductService;

import java.util.List;
import java.util.Scanner;

public class ViewMain {
    private static Scanner scanner = new Scanner(System.in);
    private static GenuineProductService genuineProductService = new GenuineProductService();
    private static HandedProductService handedProductService = new HandedProductService();

    public static void main(String[] args) {
        displayMenu();
    }
    private static void displayMenu() {
        System.out.println("\t1. Add product");
        System.out.println("\t2. Delete product");
        System.out.println("\t3. Display list product");
        System.out.println("\t4. Exit");
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            if(choice < 1 || choice > 4) System.out.print("Re-enter your choice: ");
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;

            case 3:
                display();
            case 4:
                break;
        }
        backToMainMenu();
    }

    private static void add() {
        int choice = inputYourChoose();

        System.out.print("Input name product: ");
        String name = scanner.nextLine();
        System.out.print("Input manufacturer product: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Input name price: ");
        int price = Integer.parseInt(scanner.nextLine());

        if(choice == 1) {
            System.out.print("Input warranty_period: ");
            String warranty_period = scanner.nextLine();
            HandedProduct handle = new HandedProduct(0, name, manufacturer, price, warranty_period);
            handedProductService.add(handle);
        }
        else {
            System.out.print("Input nation: ");
            String nation = scanner.nextLine();
            System.out.print("Input status: ");
            String status = scanner.nextLine();
            GenuineProduct genuine = new GenuineProduct(0, name, manufacturer, price, nation, status);
            genuineProductService.add(genuine);
        }
        System.out.println("Add Successfull !!!");
    }

    private static void delete() {
        int choice = inputYourChoose();

        boolean isHandProduct = true;
        boolean check = true;

        if(choice == 1) isHandProduct = true;
        else isHandProduct = false;
        int id;
        do{
            System.out.printf(check ? "Input id to delete: ": "Input again correct id from list to delete: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.printf("Are you sure to delete (Y/N): ");
            String answer= scanner.nextLine();
            if(answer.equalsIgnoreCase("Y")){
                try{
                    if(isHandProduct) handedProductService.delete(id);
                    else genuineProductService.delete(id);
                    System.out.println("Deleted successful!");
                    check= true;
                }
                catch (NotFoundProductException e){
                    e.printStackTrace();
                    check= false;
                }
            }
            else displayMenu();
        }while (!check);
        System.out.println("Delete Successfull !!!");
    }



    private static void display() {
        System.out.println("\t1. Display list handle products");
        System.out.println("\t2. Display list genuine products");
        System.out.println("\t3. Display all products");
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            if(choice < 1 || choice > 3) System.out.print("Re-enter your choice: ");
        } while (choice < 1 || choice > 3);

        List<HandedProduct> handleProducts;
        List<GenuineProduct> genuineProducts;
        switch (choice) {
            case 1:
                handleProducts = handedProductService.getAll();
                System.out.println("                     ------------- HANDED PRODUCTS -------------");
                System.out.printf("\t%-5s %-20s %-20s %-15s %-20s\n", "ID", "Name", "Manufacturer", "Price", "Warranty period");
                for(HandedProduct t : handleProducts) {
                    System.out.printf("\t%-5d %-20s %-20s %-15d %-20s", t.getId(), t.getName(), t.getManufacturer(), t.getPrice(), t.getWarranty_period());
                    System.out.println();
                }
                break;
            case 2:
                genuineProducts = genuineProductService.getAll();
                System.out.println("                     ------------- GENUINE PRODUCTS -------------");
                System.out.printf("\t%-5s %-20s %-20s %-15s %-20s %-20s\n", "ID", "Name", "Manufacturer", "Price", "Nation", "Status");
                for(GenuineProduct t : genuineProducts) {
                    System.out.printf("\t%-5d %-20s %-20s %-15d %-20s %-20s", t.getId(), t.getName(), t.getManufacturer(), t.getPrice(), t.getNation(), t.getStatus());
                    System.out.println();
                }
                break;
            case 3:
                handleProducts = handedProductService.getAll();
                genuineProducts = genuineProductService.getAll();
                System.out.println("                                    ------------- ALL PRODUCTS -------------");
                System.out.printf("\t%-20s %-20s %-15s %-20s %-20s %-20s\n", "Name", "Manufacturer", "Price","Warranty period", "Nation", "Status");
                for(HandedProduct t : handleProducts) {
                    System.out.printf("\t%-20s %-20s %-15d %-20s", t.getName(), t.getManufacturer(), t.getPrice(), t.getWarranty_period());
                    System.out.println();
                }
                for(GenuineProduct t : genuineProducts) {
                    System.out.printf("\t%-20s %-20s %-15d %-20s %-20s %-20s", t.getName(), t.getManufacturer(), t.getPrice(), "", t.getNation(), t.getStatus());
                    System.out.println();
                }
                break;
        }
    }

    private static void backToMainMenu() {
        System.out.printf("Do you back to main menu (Y/N): ");
        String answer= scanner.nextLine();
        if(answer.equalsIgnoreCase("Y"))    displayMenu();
        else System.exit(0);
    }

    private static int inputYourChoose(){
        System.out.printf("1. Hand products\n2. Genuine products\n");
        int choose;
        do {
            System.out.printf("Input your choose: ");
            choose= Integer.parseInt(scanner.nextLine());
        } while (choose < 1 || choose > 2);

        return choose;
    }
}
