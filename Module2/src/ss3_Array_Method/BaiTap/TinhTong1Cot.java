package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class TinhTong1Cot {
    public static void main(String[] args) {
        int sum = 0;
        int row, col;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng của ma trận: ");
        row = scanner.nextInt();
        System.out.print("Nhập vào số cột của ma trận: ");
        col = scanner.nextInt();
        double [][] arr = new double[row][col];
        // Nhập giá trị mảng 2 chiều
        System.out.println("NHẬP GIÁ TRỊ PHẦN TỬ TRONG MẢNG");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Nhập giá trị phần tử arr[" + i + "][" + j + "] = ");
                arr[i][j] = scanner.nextDouble();
            }
        }
        // Xuất mảng 2 chiều
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                System.out.print(arr[i][j] + "\t");
            System.out.print("\n");
        }
        System.out.print("Nhập vào vị trí cột cần tính tổng: ");
        int cot = scanner.nextInt();
        for(int i=0;i<row;i++){
            sum += arr[i][cot];
        }
        System.out.println("Tổng giá trị phần tử cột thứ " + cot + " = " + sum);
    }
}
