package ss6_Inheritance.BaiTap.Point_And_MoveablePoint;

public class Test {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(1,2,3,4);
        System.out.println("Trước khi di chuyển: ");
        System.out.println("\t" + moveablePoint.toString());
        System.out.println("Sau khi di chuyển: ");
        moveablePoint = moveablePoint.move();
        System.out.println("\t" + moveablePoint.toString());
    }
}
