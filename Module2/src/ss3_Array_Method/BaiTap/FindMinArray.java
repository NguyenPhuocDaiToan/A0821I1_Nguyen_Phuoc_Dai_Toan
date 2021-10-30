package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class FindMinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Nhập vào kích thước của mảng: ");
        size = scanner.nextInt();
        int [] arr = new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];
        for(int i=1;i<size;i++){
            if(arr[i]<min)  min = arr[i];
        }
        System.out.println("Giá trị phần tử nhỏ nhất trong mảng là: " + min);
    }
}
