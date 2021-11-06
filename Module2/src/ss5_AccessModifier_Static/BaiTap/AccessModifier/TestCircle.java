package ss5_AccessModifier_Static.BaiTap.AccessModifier;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius;
        System.out.print("Nhập bán kính của hình tròn: ");
        radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Bán kính hình tròn là: " + circle.getRadius());
        System.out.println("Diện tích hình tròn là: " + circle.getArea());
    }
}
