package ss2_LoopJava.BaiTap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the triangle");
            System.out.println("3. Draw isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            int height, length, width;
            switch (choice) {
                case 1:
                    System.out.print("Nhập chiều dài: ");
                    length = sc.nextInt();
                    System.out.print("Nhập chiều rộng: ");
                    width = sc.nextInt();
                    String edge = "";
                    System.out.println("Draw the rectangle");
                    for(int i=1;i<=width;i++)       edge += "* ";

                    for(int i=1;i<=length;i++)      System.out.println('\t' + edge);
                    break;
                case 2:
                    System.out.println("Draw the triangle");
                    System.out.print("Nhập chiều cao tam giác: ");
                    height = sc.nextInt();
                    System.out.println("Triangle top-left:");
                    for(int i=height;i>=1;i--){
                        System.out.print('\t');
                        for(int j=i;j>=1;j--)           System.out.print("* ");
                        System.out.print('\n');
                    }
                    System.out.println("Triangle top-right:");
                    for(int i=height;i>=1;i--){
                        System.out.print('\t');
                        for(int j=i;j<height;j++)       System.out.print("  ");
                        for(int j=i;j>=1;j--)           System.out.print("* ");
                        System.out.print('\n');
                    }
                    System.out.println("Triangle bottom-left:");
                    for(int i=1;i<=height;i++){
                        System.out.print('\t');
                        for(int j=1;j<=i;j++)   System.out.print("* ");
                        System.out.print('\n');
                    }
                    System.out.println("Triangle bottom-right:");
                    for(int i=1;i<=height;i++){
                        System.out.print('\t');
                        for(int j=i;j<height;j++)       System.out.print("  ");
                        for(int j=1;j<=i;j++)           System.out.print("* ");
                        System.out.print('\n');
                    }
                    break;
                case 3:
                    System.out.println("Draw isosceles triangle");
                    System.out.print("Nhập chiều cao tam giác cân: ");
                    height = sc.nextInt();
                    for(int i=1;i<=height;i++){
                        System.out.print('\t');
                        for(int j=1;j<=height-i;j++)    System.out.print(" ");
                        for(int j=1;j<=2*i-1;j++)       System.out.print("*");
                        System.out.print('\n');
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        } while(choice != 0);
    }
}
