package ss4_Class_And_Object.ThucHanh;

public class Rectangle {
    double width, height;
    public Rectangle(){

    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.width * this.height;
    }
    public double getPerimeter(){
        return 2 * (this.height + this.width);
    }
    public String display(){
        return "Rectangle:\t" + "width = " + width + ";" + "\theight = " + height;
    }
}
