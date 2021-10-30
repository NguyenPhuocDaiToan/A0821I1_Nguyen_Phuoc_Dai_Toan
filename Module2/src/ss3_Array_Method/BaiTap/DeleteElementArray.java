package ss3_Array_Method.BaiTap;

import java.util.Scanner;

public class DeleteElementArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào phần tử cần xóa: ");
        int element = scanner.nextInt();
        boolean check = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == element){
                check = true;
                System.out.println("Position of " + element + " is " + i);
                for(int j=i;j<arr.length-1;j++){
                    arr[j] = arr[j+1];
                }
                break;
            }
        }
        if(!check) System.out.println(element + " is not exist in array");
        else{
            System.out.println("After array is: ");
            for (int i=0;i<arr.length-1;i++){
                System.out.print(arr[i] + "\t");
            }
        }
    }
}
