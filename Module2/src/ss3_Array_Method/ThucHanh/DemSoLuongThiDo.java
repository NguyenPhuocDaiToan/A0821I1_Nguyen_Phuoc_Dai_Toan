package ss3_Array_Method.ThucHanh;

import java.util.Scanner;

public class DemSoLuongThiDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, count = 0;
        do{
            System.out.print("Nhập vào số lượng sinh viên: ");
            size = scanner.nextInt();
            if(size>30)
                System.out.println("Số lượng sinh viên không vượt quá 30");
        } while(size>30);
        double [] sinhVien = new double[size];
        for(int i=0;i<size;i++){
            System.out.print("Nhập vào điểm sinh viên thứ " + (i+1) + ": ");
            sinhVien[i] = scanner.nextDouble();
        }
        System.out.print("Danh sách điểm sinh viên: ");
        for(int i=0;i<size;i++){
            System.out.print(sinhVien[i] + "\t");
            if(sinhVien[i]>=5 && sinhVien[i]<=10)
                count++;
        }
        System.out.println("\nSố lượng sinh viên thi đỗ là: " + count);
    }
}
