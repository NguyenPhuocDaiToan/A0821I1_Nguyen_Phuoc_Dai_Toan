package ss7_Abstract_Interface.BaiTap.Colorable;

public class MainTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2);
        shapes[1] = new Rectangle(1, 2);
        shapes[2] = new Square(2);
        shapes[0].howToColor();
        shapes[2].howToColor();
    }
}
