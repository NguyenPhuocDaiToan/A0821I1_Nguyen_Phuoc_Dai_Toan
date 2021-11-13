package ss6_Inheritance.BaiTap.Triangle;

public class Triangle extends Shape{
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;
    public Triangle() {

    }
    public Triangle(double a, double b, double c, String color) {
        super(color);
        if(a+b>c && b+c>a && c+a>b) {
            side1 = a;
            side2 = b;
            side3 = c;
        }
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public double getArea() {
        double p = this.getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    public String toString() {
        return "a = " + side1 + "\tb = " + side2 + "\tb = " + side3;
    }
}
