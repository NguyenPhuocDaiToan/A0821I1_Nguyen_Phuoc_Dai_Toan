package ss4_Class_And_Object.BaiTap.QuadraticEquation;

public class QuadraticEquation {
    double a, b, c;
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getDiscriminant(){
        return this.b * this.b - 4 * this.a * this.c;
    }
    public double getRoot1(){
        if(this.getDiscriminant()<0){
            return 0;
        }
        else {
            return (-this.b - Math.sqrt(this.getDiscriminant()))/(2*a);
        }
    }
    public double getRoot2(){
        if(this.getDiscriminant()<0){
            return 0;
        }
        else {
            return (-this.b + Math.sqrt(this.getDiscriminant()))/(2*a);
        }
    }
}
