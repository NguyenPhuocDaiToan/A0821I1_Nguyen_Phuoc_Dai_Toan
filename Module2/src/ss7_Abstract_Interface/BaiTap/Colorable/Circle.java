package ss7_Abstract_Interface.BaiTap.Colorable;

public class Circle extends Shape {
    private double radius = 1.0;
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getParameter() {
        return 2 * radius * Math.PI;
    }
    public double getArea() {
        return Math.PI * radius *radius;
    }
    public String toString() {
        return "A Circle\tradius = " + getRadius();
    }
    public void howToColor() {
        System.out.println("Color all Circle");
    }
}

