package ss3_Array_Method.BaiTap;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class DemSoLanXuatHien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        char c;
        int count = 0;
        System.out.print("Nhập vào chuỗi: ");
        text = scanner.nextLine();
        System.out.print("Nhập vào kí tự cần đếm: ");
        c = scanner.next().charAt(0);
        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == c)
                count++;
        }
        System.out.println(count);
    }
}
