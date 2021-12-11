package Furama_Resort.views;

import Furama_Resort.service.Impl.EmployeeServiceImpl;
import Furama_Resort.utils.CommonUtil;

public class EmployeeView {
    static void employeeManger() {
        System.out.println("\t1. Display list employees");
        System.out.println("\t2. Add new employee");
        System.out.println("\t3. Edit employee");
        System.out.println("\t4. Return main menu");

        int choice;
        do{
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(CommonUtil.getScanner().nextLine());
            if(choice < 1 || choice > 4) {
                System.out.println("Your input is invalid.");
                System.out.println("Please re-enter choice valid from 1 - 4.");
            }
        } while (choice < 1 || choice > 4);

    }
}
