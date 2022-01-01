package Furama_Resort.views;

import Furama_Resort.utils.CommonUtil;

public class HomeView {
    public static void main(String[] args) {
        displayMainMenu();
    }
    private static void displayMainMenu() {
        System.out.println("\t1. Employee Management");
        System.out.println("\t2. Customer Management");
        System.out.println("\t3. Facility Management");
        System.out.println("\t4. Booking Management");
        System.out.println("\t5. Promotion Management");
        System.out.println("\t6. Exit");
        int choice;
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
                EmployeeView.employeeManger();
                break;
            case 2:
                CustomerView.customerManger();
                break;
            case 3:
                FacilityView.facilityManger();
                break;
            case 4:
                BookingView.bookingManger();
                break;
            case 5:
                PromotionView.promotionManger();
                break;
            case 6:
                System.exit(0);
                break;
        }
        backToMainMenu();
    }

    static private void backToMainMenu() {
        System.out.print("Do you to back main menu (Y/N): ");
        String anwser;
        do {
            anwser = CommonUtil.getScanner().nextLine();
            if(anwser.equalsIgnoreCase("Y") || anwser.equalsIgnoreCase("N"))
                break;
            else System.out.print("Input invalid. Please re-enter input: ");
        } while(true);

        if(anwser.equalsIgnoreCase("Y"))    displayMainMenu();
        else System.exit(0);
    }
}
