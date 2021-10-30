package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class AddElementArray {
    public static void main(String[] args) {
        int size;
        // Nhập phần tử của mảng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        size = scanner.nextInt();
        int [] arr = new int[size+1];

        // Khởi tạo giá trị của mảng
        for(int i=0;i<size;i++){
            System.out.print("Enter element " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        // Nhập vị trí và phần tử cần thêm
        int index, value;
        System.out.print("Enter the position of the element to be added: ");
        index = scanner.nextInt();
        System.out.print("Enter the value of the element to be added: ");
        value = scanner.nextInt();

        if(index<0 || index>size) System.out.println("Index is invalid");
        else{
            for(int i = size; i>index;i--){
                arr[i] = arr[i-1];
            }
            arr[index] = value;
        }
        for(int i=0;i<=size;i++){
            System.out.print(arr[i] + "\t");
        }
    }
}
