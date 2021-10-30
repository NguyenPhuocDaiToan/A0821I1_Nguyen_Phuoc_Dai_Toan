package ss2_LoopJava.BaiTap;

import java.util.Scanner;

public class DisplayPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng số nguyên tố cần in: ");
        int number = sc.nextInt();
        int count = 0;
        int value = 2;
        boolean check;
        while(count<number){
            check = true;
            for(int i=2;i<=Math.sqrt(value);i++){
                if(value%i==0){
                    check = false;
                    break;
                }
            }
            if(check==true){
                System.out.print(value + " ");
                if(count%10==0) System.out.print('\n');
                count++;
            }
            value++;
        }
    }
}
