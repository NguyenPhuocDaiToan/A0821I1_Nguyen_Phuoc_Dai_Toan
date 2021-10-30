package ss3_Array_Method.ThucHanh;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int [] arr;
        do{
            System.out.print("Enter size of array: ");
            size = input.nextInt();
            if(size>20){
                System.out.println("Size should not exceed 20");
            }
        } while(size>20);

        // Cấp phát và nhập giá trị cho mảng
        arr = new int [size];
        for(int i=0;i<size;i++){
            System.out.print("Enter element" + (i+1) + " : ");
            arr[i] = input.nextInt();
        }
        // Xuất mảng và tìm max
        int max = arr[0];
        int maxIndex = 0;
        System.out.print("Array: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + "\t");
            if(arr[i]>max){
                max = arr[i];
                maxIndex = i;
            }
        }
        // Xuất phẩn tử lớn nhất của mảng
        System.out.println("\nThe largest property value in the list is " + max + " ,at position " + maxIndex);
    }
}
