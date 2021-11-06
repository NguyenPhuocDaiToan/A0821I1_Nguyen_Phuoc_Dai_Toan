package ss4_Class_And_Object.BaiTap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    static {
        System.out.println("Static");
    }
    {
        System.out.println("Instance");
    }
    public void Main() {
        System.out.println("Constructor");
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        System.out.println("Phương trình có dạng ax^2 + bx + c = 0");
        System.out.print("Nhập giá trị a = ");
        a = sc.nextDouble();
        System.out.print("Nhập giá trị b = ");
        b = sc.nextDouble();
        System.out.print("Nhập giá trị c = ");
        c = sc.nextDouble();
        QuadraticEquation object = new QuadraticEquation(a, b, c);
        if(object.getDiscriminant()<0){
            System.out.println("Phương trình vô nghiệm");
        }
        else if(object.getDiscriminant() == 0){
            System.out.print("Phương trình có 1 nghiệm duy nhất là: " + object.getRoot1());
        }
        else{
            System.out.println("Phương trình có hai nghiệm phân biệt: ");
            System.out.println("\tx1 = " + object.getRoot1());
            System.out.println("\tx2 = " + object.getRoot2());
        }
        Main t = new Main();
    }
}
