package ss6_Inheritance.BaiTap.Point2D_And_Point3D;

public class Point3D extends Point2D {
    private float z = 0.0f;
    public Point3D() {

    }
    public Point3D(float x, float y, float z) {
        super(x,y);
        this.z = z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public float getZ() {
        return this.z;
    }
    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }
    public float[] getXYZ() {
        float[] XYZ = {super.getX(), super.getY(), getZ()};
        return XYZ;
    }
    public String toString() {
        return "(" + getX() +"," + getY() + "," + getZ() + ")";
    }
}
