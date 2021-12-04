package ss15_Exception_Debug.BaiTap;

public class Triangle {
    private float a, b, c;

    public Triangle() {
    }
    public Triangle(float a, float b, float c) throws IllegalTriangleException{
        this.a = a;
        this.b = b;
        this.c = c;

        if(a + b <= c || b + c <= a || c + a <= b)
            throw new IllegalTriangleException("Not triangle");
    }
}
