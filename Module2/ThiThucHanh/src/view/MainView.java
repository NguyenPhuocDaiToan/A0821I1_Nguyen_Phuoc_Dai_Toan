package view;

import common.AppConstant;
import exception.NotFoundBankAccountException;
import model.AccountBank;
import model.AccountPayment;
import model.AccountSaving;
import service.AccountService;


import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainView {
    private static Pattern pattern;
    private static Matcher matcher;
    private static Scanner scanner = new Scanner(System.in);
    private static AccountService  accountService= new AccountService();

    public static void main(String args[]) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("--- Account Banking ---");
        System.out.println("\t1. Add\n\t2. Delete\n\t3. Display\n\t4. Search\n\t5. Exit");

        int choice = inputChoice(5);

        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                List<AccountBank> accountBanks = accountService.getAll();
                display(accountBanks);
                break;
            case 4:
                search();
                break;
            case 5:
                System.exit(0);
                break;
        }
        backToMainMenu();
    }

    private static void add() {
        System.out.println("\t1. Add account saving\n\t2. Add account payment");
        int choice = inputChoice(2);
        System.out.print("Input account: ");
        String account = scanner.nextLine();
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input dateCreat: ");
        String dateCreat = scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Input amount of savings: ");
                double amount_of_savings = Double.parseDouble(scanner.nextLine());
                System.out.print("Input date saving: ");
                String dateSaving = scanner.nextLine();
                System.out.print("Input date interest rate: ");
                float interest_rate = Float.parseFloat(scanner.nextLine());
                System.out.print("Input month: ");
                int month = Integer.parseInt(scanner.nextLine());
                AccountBank accountSaving = new AccountSaving(0, account, name, dateCreat, amount_of_savings, dateSaving, interest_rate, month);
                accountService.add(accountSaving);
                break;
            case 2:
                System.out.print("Input card: ");
                String card = scanner.nextLine();
                System.out.print("Input ammount: ");
                double ammount = Double.parseDouble(scanner.nextLine());
                AccountBank accountPayment = new AccountPayment(0, account, name, dateCreat, card, ammount);
                accountService.add(accountPayment);
                break;
        }
        System.out.println("Add account successful");
    }

    private static void delete() {
        System.out.print("Input id to delete account banking: ");
        int id = Integer.parseInt(scanner.nextLine());
        String answer;
        do {
            System.out.print("Do you want to delete (Y/N): ");
            answer = scanner.nextLine();
            if(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"))
                System.out.println("Input invalid. Re-enter input Y or N to delete");
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        try {
            accountService.delete(id);
            System.out.println("Delete Successful");
        }
        catch (NotFoundBankAccountException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void display(List<AccountBank> accountBanks) {
        System.out.println("                                      ------------ ACCOUNT BANKING ------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-25s %-15s", "ID", "Account", "Full Name", "Date creat");
        System.out.printf("%-20s %-20s", "Card" , "Ammount in account");
        System.out.printf("%-20s %-15s %-15s %-5s\n", "Amount of savings", "Date saving" , "Interest rate", "Month");

        for(AccountBank accountBank : accountBanks) {
            System.out.printf("%-5d %-15s %-25s %-15s", accountBank.getId(), accountBank.getAccount(), accountBank.getName(), accountBank.getDateCreat());
            if(accountBank instanceof AccountSaving) {
                AccountSaving accountSaving = (AccountSaving) accountBank;
                System.out.printf("%-20s%-20s %-20.1f %-15s ", "", "", accountSaving.getAmount_of_savings(), accountSaving.getDateSaving());
                System.out.printf("%-15.1f %-5d\n", accountSaving.getInterest_rate(), accountSaving.getMonth());
            }
            else {
                AccountPayment accountPayment = (AccountPayment) accountBank;
                System.out.printf("%-20s %-20.1f\n", accountPayment.getCard() , accountPayment.getAmmount());
            }
        }
    }
    private static void search() {
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        List<AccountBank> accountBanks = accountService.search(name);
        display(accountBanks);
    }
    private static int inputChoice(int end) {
        int choice = 0;
        String temp;
        boolean isNumber = false;
        pattern = Pattern.compile(AppConstant.numberRegex.isNumber);
        do {
            System.out.print("Input choice from 1 to " + end + ": ");
            temp = scanner.nextLine();
            matcher = pattern.matcher(temp);
            if(matcher.matches()) {
                choice = Integer.parseInt(temp);
                if(choice >= 1 && choice <= end)    isNumber = true;
                else isNumber = false;
            }
            else isNumber = false;
        } while (!isNumber);
        return choice;
    }

    private static void backToMainMenu() {
        String answer;
        boolean checkAnswer;
        do {
            checkAnswer = true;
            System.out.print("Do you back to main menu (Y/N): ");
            answer = scanner.nextLine();
            if(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                checkAnswer = false;
            }
        } while (!checkAnswer);

        if(answer.equalsIgnoreCase("Y"))
            displayMainMenu();
        else System.exit(0);
    }
}
