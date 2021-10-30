package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class PhanTuLonNhatMang2Chieu {
    public static void main(String[] args) {
        double max;
        int x, y;
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
        // Tìm max
        max = arr[0][0];
        x = 0;
        y = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j] >  max){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất của mảng 2 chiều là " +  max + " ở vị trí [" + x + "][" + y + "]");
    }
}
