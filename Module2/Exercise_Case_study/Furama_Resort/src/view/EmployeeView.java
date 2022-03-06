package view;

import controller.EmployeeController;
import model.Employee;
import util.ConstantUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static util.CommonUtil.getScanner;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();

    public static void employeeManager() {
        System.out.println("\t1. Display list employees");
        System.out.println("\t2. Add new employee");
        System.out.println("\t3. Edit employee");
        System.out.println("\t4. Delete employee");
        System.out.println("\t5. Return main menu");
        System.out.print("Input your choice: ");
        int choice = Integer.parseInt(getScanner().nextLine());

        while(choice < 1 || choice > 5) {
            System.out.print("Input your choice is invalid. Please re-enter input your choice: ");
            choice = Integer.parseInt(getScanner().nextLine());
        }

        switch (choice) {
            case 1:
                displayList();
                break;
            case 2:
                employeeController.save(input());
                break;
            case 3:
//                employeeController.save();
                break;
            case 4:
//                employeeController.delete();
                break;
            case 5:
                HomeView.displayMainMenu();
                break;
        }
    }
    private static void displayList() {
        List<Employee> employees = employeeController.getAll();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ LIST EMPLOYEES ============");
        System.out.printf("%-5s %-10s %-20s %-15s %-15s %-15s %-20s %-20s %-15s %-15s %-15s\n", "ID", "CODE", "NAME", "GENDER",
                "BIRTH DAY", "PHONE", "EMAIL", "ADDRESS", "DEGREE", "POSITION", "SALARY");
        for(Employee e : employees) {
            System.out.printf("%-5d %-10s %-20s %-15s %-15s %-15s %-20s %-20s %-15s %-15s %-15.0f\n", e.getId(), e.getCode(), e.getName(),
                    e.getGender(), e.getBirthday(), e.getPhone(), e.getEmail(), e.getAddress(), e.getDegree(), e.getPosition(), e.getSalary());
        }
    }
    private static Employee input() {
        System.out.print("Enter code: ");
        String code = getScanner().nextLine();

        System.out.print("Enter name: ");
        String name = getScanner().nextLine();

        System.out.print("Enter gender: ");
        String gender = getScanner().nextLine().toUpperCase();

        System.out.print("Enter birthday: ");
        String birthday = getScanner().nextLine();

        System.out.print("Enter phone: ");
        String phone = getScanner().nextLine();

        System.out.print("Enter email: ");
        String email = getScanner().nextLine();

        System.out.print("Enter address: ");
        String address = getScanner().nextLine();

        System.out.print("Enter degree: ");
        String degree = getScanner().nextLine().toUpperCase();

        System.out.print("Enter position: ");
        String position = getScanner().nextLine().toUpperCase();

        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(getScanner().nextLine());

        return new Employee(0, code, name, Gender.valueOf(gender), birthday, phone, email, address,
                Degree.valueOf(degree), Position.valueOf(position), salary);
    }
}
