package ss7_Abstract_Interface.BaiTap.Resizeable;

public class Square extends Shape{
    private double side = 1.0;
    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String toString() {
        return "A Square: " + "\tside = " + getSide();
    }

    public void resize(double percent) {
        this.setSide(getSide() * (1 + percent/100));
    }
}