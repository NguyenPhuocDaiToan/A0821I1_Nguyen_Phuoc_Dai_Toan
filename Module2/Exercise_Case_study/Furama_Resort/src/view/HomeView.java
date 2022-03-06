package view;

import java.util.Scanner;

import static util.CommonUtil.getScanner;

public class HomeView {

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("\t1. Employee Management");
        System.out.println("\t2. Customer Management");
        System.out.println("\t3. Facility Management");
        System.out.println("\t4. Booking Management");
        System.out.println("\t5. Promotion Management");
        System.out.println("\t6. Exit");
        System.out.print("Input your choice: ");
        int choice = Integer.parseInt(getScanner().nextLine());

        while(choice < 1 || choice > 6) {
            System.out.print("Input your choice is invalid. Please re-enter input your choice: ");
            choice = Integer.parseInt(getScanner().nextLine());
        }

        switch (choice) {
            case 1:
                EmployeeView.employeeManager();
                break;
            case 2:
                CustomerView.customerManager();
                break;
            case 3:
                FacilityView.facilityManager();
                break;
            case 4:
                BookingView.bookingManager();
                break;
            case 5:
                PromotionView.promotionManager();
                break;
            case 6:
                System.exit(0);
        }
        backToMainMenu();
    }

    static private void backToMainMenu(){
        System.out.print("Do you to back main menu (Y/N): ");
        String answer = getScanner().nextLine();
        if(answer.equalsIgnoreCase("Y"))
            displayMainMenu();
        else System.exit(0);
    }
}
