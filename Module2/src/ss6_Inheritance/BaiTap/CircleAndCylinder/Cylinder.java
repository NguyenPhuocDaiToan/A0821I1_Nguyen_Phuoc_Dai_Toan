package ss6_Inheritance.BaiTap.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder() {
    }
    public Cylinder(double height) {
        this.height =  height;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getHeight() {
        return this.height;
    }
    public double getVolume() {
        return super.getArea() * this.height;
    }
    public String toString() {
        String temp = "Cylinder:\tRadius is " + getRadius() +"\tColor is " + getColor();
        temp += "\tHeight is " + getHeight();
        return temp;
    }
}
