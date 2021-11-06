package ss4_Class_And_Object.ThucHanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width, height;

        System.out.print("Nhập chiều dài hình chữ nhật: ");
        width = sc.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        height = sc.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Hình chữ nhật vừa nhập là: " + rectangle.display());
        System.out.println("Chu vi hình chữ nhật là: " + rectangle.getPerimeter());
        System.out.println("Diện tích hình chữ nhật là: " +  rectangle.getArea());
    }
}
