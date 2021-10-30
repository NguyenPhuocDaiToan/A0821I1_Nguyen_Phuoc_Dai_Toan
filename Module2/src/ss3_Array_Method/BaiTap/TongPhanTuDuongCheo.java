package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class TongPhanTuDuongCheo {
    public static void main(String[] args) {
        int sum = 0;
        int row;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng của ma trận vuông: ");
        row = scanner.nextInt();
        double [][] arr = new double[row][row];
        // Nhập giá trị mảng 2 chiều
        System.out.println("NHẬP GIÁ TRỊ PHẦN TỬ TRONG MẢNG");
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                System.out.print("Nhập giá trị phần tử arr[" + i + "][" + j + "] = ");
                arr[i][j] = scanner.nextDouble();
            }
        }
        // Xuất mảng 2 chiều
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++)
                System.out.print(arr[i][j] + "\t");
            System.out.print("\n");
        }

        for(int i=0;i<row;i++){
            sum += arr[i][i];
        }
        System.out.println("Tổng giá trị phần tử đường chéo chính = " + sum);
    }
}
