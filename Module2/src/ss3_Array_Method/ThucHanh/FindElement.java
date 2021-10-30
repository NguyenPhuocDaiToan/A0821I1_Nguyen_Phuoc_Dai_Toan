package ss3_Array_Method.ThucHanh;

import java.util.Scanner;

public class FindElement {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Nhập tên học sinh cần tìm kiếm: ");
        String input_name = sc.nextLine();
        boolean isExist = false;
        for(int i=0; i<students.length; i++){
            if(students[i].equals(input_name)){
                isExist = true;
                System.out.println("Position of the students in array " + input_name + " is: " + (i + 1));
                break;
            }
        }
        if(!isExist)    System.out.println("Not found " + input_name + " in array.");
    }
}
