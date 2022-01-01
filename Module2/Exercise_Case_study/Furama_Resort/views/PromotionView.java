package Furama_Resort.views;

import Furama_Resort.utils.CommonUtil;

public class PromotionView {
    static void promotionManger() {
        System.out.println("\t1. Display list customer use service");
        System.out.println("\t2. Display list customer get voucher");
        System.out.println("\t3. Return main menu");

        int choice;
        do{
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(CommonUtil.getScanner().nextLine());
            if(choice < 1 || choice > 3) {
                System.out.println("Your input is invalid.");
                System.out.println("Please re-enter choice valid from 1 - 3.");
            }
        } while (choice < 1 || choice > 3);
    }
}
