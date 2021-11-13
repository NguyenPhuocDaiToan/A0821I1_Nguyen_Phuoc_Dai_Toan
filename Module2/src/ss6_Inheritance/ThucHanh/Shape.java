package ss6_Inheritance.ThucHanh;

public class Shape {
    private String color;
    private boolean filled;
    public Shape() {
        this.color = "green";
        this.filled = true;
    }
    public Shape(String color, boolean filled) {
        this.color =  color;
        this.filled = filled;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String getColor() {
        return this.color;
    }
    public boolean isFilled() {
        return this.filled;
    }
    public String toString() {
        String temp = "A Shape with color of"+  getColor() + " and";
        if(isFilled()) temp += " filled";
        else temp += " not filled";
        return temp;
    }
}
