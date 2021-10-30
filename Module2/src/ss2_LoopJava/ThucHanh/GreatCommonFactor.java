package ss2_LoopJava.ThucHanh;

import java.util.Scanner;

public class GreatCommonFactor {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = sc.nextInt();
        System.out.println("Enter b: ");
        b = sc.nextInt();
        while(a*b!=0){
            if(a>b){
                a = a % b;
            }
            else b = b % a;
        }
        if(a==0 && b==0) System.out.println("No greatest common factor");
        else System.out.println("Greatest common factor: " + (a+b));
    }
}
