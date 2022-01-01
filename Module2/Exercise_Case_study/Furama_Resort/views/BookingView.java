package Furama_Resort.views;

import Furama_Resort.utils.CommonUtil;

public class BookingView {
    static void bookingManger() {
        System.out.println("\t1. Display list booking");
        System.out.println("\t2. Add new booking");
        System.out.println("\t3. Edit booking");
        System.out.println("\t4. Return main menu");
        System.out.println("\t5. Edit contracts");
        System.out.println("\t6. Return main menu");

        int choice;
        do{
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(CommonUtil.getScanner().nextLine());
            if(choice < 1 || choice > 6) {
                System.out.println("Your input is invalid.");
                System.out.println("Please re-enter choice valid from 1 - 6.");
            }
        } while (choice < 1 || choice > 6);
    }
}
