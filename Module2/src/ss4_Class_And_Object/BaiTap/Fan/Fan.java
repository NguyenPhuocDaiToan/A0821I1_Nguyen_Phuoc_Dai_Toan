package ss4_Class_And_Object.BaiTap.Fan;

public class Fan {
    final int SLOW = 1, MEDIUM = 2, FAST = 3;
    int speed = SLOW;
    boolean on = false;
    double radius = 5;
    String color = "blue";
    public Fan(){

    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setOn(boolean status){
        this.on = status;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getSpeed(){
        return this.speed;
    }
    public boolean getOn(){
        return this.on;
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public String ToString(){
        String s = "Speed: " + this.speed + ";\tColor: " + this.color
                + ";\tRadius: " + this.radius + ";\t";
        if(this.on){
            s += "Fan is on";
        }
        else{
            s += "Fan is off";
        }
        return s;
    }
}
