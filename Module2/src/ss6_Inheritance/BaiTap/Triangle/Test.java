package ss6_Inheritance.BaiTap.Triangle;

public class Test {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5,"RED");
        System.out.println(triangle.toString());
        System.out.println("Màu sắc: " + triangle.getColor());
        System.out.println("Chu vi: " + triangle.getPerimeter());
        System.out.println("Diện tích: " + triangle.getArea());
    }
}
