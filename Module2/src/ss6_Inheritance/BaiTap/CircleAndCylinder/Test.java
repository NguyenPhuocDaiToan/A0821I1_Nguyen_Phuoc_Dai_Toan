package ss6_Inheritance.BaiTap.CircleAndCylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "Red");
        Cylinder cylinder = new Cylinder(3, "Blue", 2);
        System.out.println(circle.toString());
        System.out.println("\tArea = " + circle.getArea());
        System.out.println("\tPerimeter = " + circle.getPerimeter());
        System.out.println(cylinder.toString());
        System.out.println("\tVolume = " + cylinder.getVolume());
    }
}
