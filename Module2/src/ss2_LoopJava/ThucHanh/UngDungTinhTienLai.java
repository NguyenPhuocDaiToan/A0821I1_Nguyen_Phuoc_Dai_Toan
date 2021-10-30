package ss2_LoopJava.ThucHanh;

import java.util.Scanner;

public class UngDungTinhTienLai {
    public static void main (String [] args){
        double money;
        double interestRate;
        int month;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = sc.nextDouble();
        System.out.println("Enter number of months: ");
        month = sc.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = sc.nextDouble();
        double totalInterest = 0;
        for(int i=1;i<=month;i++){
            totalInterest += money*(interestRate/100)/12*month;
        }
    }
}
