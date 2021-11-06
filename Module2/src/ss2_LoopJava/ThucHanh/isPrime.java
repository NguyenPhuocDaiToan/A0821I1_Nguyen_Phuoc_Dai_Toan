package ss2_LoopJava.ThucHanh;

import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên cần kiểm tra: ");
        a = sc.nextInt();
        if(a<2) System.out.println(a + " is not a prime");
        else{
            boolean check = true;
            int i = 2;
            while(i <= Math.sqrt(a)){
                if(a%i==0){
                    check =false;
                    break;
                }
                i++;
            }
            if(check) System.out.println(a + " is a prime");
            else System.out.println(a + " is not a prime");
        }
    }
}


