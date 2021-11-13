package ss6_Inheritance.BaiTap.CircleAndCylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle() {

    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public String toString() {
        return "Circle:\tRadius is " + getRadius() +"\tColor is " + getColor();
    }
}
