package ss1_IntroduceJava.BaiTap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main (String [] args) {
        double VND = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        double USD = scanner.nextDouble();
        System.out.println(USD + "USD = " + USD*VND + "VNĐ");
    }
}
