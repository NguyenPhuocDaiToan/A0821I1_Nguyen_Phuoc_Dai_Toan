package ss6_Inheritance.BaiTap.Point2D_And_Point3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    public Point2D(){

    }
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        float[] XY = {this.x, this.y};
        return XY;
    }
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
