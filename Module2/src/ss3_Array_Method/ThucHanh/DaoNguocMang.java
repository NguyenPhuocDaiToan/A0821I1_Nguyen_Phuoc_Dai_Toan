package ss3_Array_Method.ThucHanh;

import java.util.Scanner;

public class DaoNguocMang {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int size;
        do{
            System.out.print("Enter a size of array: ");
            size = sc.nextInt();
            if(size>20) System.out.println("Size does not exceed 20.");
        } while(size>20);

        int [] array = new int [size];
        for(int i=0;i<size;i++){
            System.out.print("Enter element " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.printf("%-20s%s", "Element in array:", "");
        for(int i=0;i<size;i++){
            System.out.print(array[i] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
