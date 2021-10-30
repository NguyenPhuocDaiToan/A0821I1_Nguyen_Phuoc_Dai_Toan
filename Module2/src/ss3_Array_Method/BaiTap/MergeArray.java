package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size1, size2;
        System.out.print("Nhập kích thước mảng 1: ");
        size1 = scanner.nextInt();
        System.out.print("Nhập kích thước mảng 2: ");
        size2 = scanner.nextInt();
        int [] arr1 = new int [size1];
        int [] arr2 = new int [size2];
        System.out.print("\t\tNHẬP GIÁ TRỊ PHẦN TỬ CỦA MẢNG 1\n");
        for(int i=0;i<size1;i++)
        {
            System.out.print("Nhập giá trị phần tử thứ " + i + " của mảng 1: ");
            arr1[i] = scanner.nextInt();
        }
        System.out.print("\t\tNHẬP GIÁ TRỊ PHẦN TỬ CỦA MẢNG 2\n");
        for(int i=0;i<size2;i++)
        {
            System.out.print("Nhập giá trị phần tử thứ " + i + " của mảng 2: ");
            arr2[i] = scanner.nextInt();
        }
        int size3 =size1+size2;
        int [] arr3 = new int [size3];
        for(int i=0; i<size1;i++){
            arr3[i] = arr1[i];
        }

        for(int i=0; i<size2;i++){
            arr3[i+size1] = arr2[i];
        }
        System.out.println("Mảng 1: ");
        for(int i=0;i<size1;i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\nMảng 2: ");
        for(int i=0;i<size2;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\nMảng 3 là mảng 1 + mảng 2: ");
        for(int i=0;i<size3;i++){
            System.out.print(arr3[i] + " ");
        }
    }
}
