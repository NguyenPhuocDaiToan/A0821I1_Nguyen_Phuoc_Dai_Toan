package ss6_Inheritance.BaiTap.Triangle;

public class Shape {
    private String color;
    public Shape() {
        this.color = "green";
    }
    public Shape(String color) {
        this.color =  color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}
