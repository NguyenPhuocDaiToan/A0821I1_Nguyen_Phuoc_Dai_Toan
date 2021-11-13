package ss7_Abstract_Interface.BaiTap.Resizeable;

public class MainTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(1,2);
        shapes[2] = new Square(4);
        System.out.println("Before: ");
        System.out.println(shapes[0].toString());
        System.out.println(shapes[1].toString());
        System.out.println(shapes[2].toString());
        shapes[0].resize(75);
        shapes[1].resize(50);
        shapes[2].resize(60);
        System.out.println("After: ");
        System.out.println(shapes[0].toString());
        System.out.println(shapes[1].toString());
        System.out.println(shapes[2].toString());
    }
}
