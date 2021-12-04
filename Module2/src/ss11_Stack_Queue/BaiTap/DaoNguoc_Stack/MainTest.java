package ss11_Stack_Queue.BaiTap.DaoNguoc_Stack;

import java.util.Stack;

public class MainTest {
    public static void reverseInt(int []arrayInteger) {
        Stack<Integer> stack = new Stack<>();
        int size = arrayInteger.length;
        for(int i = 0; i < size; i++) {
            stack.push(arrayInteger[i]);
        }
        for(int i = 0; i < size; i++) {
            arrayInteger[i] = stack.pop();
        }
    }
    public static String reverseString(String arrayString) {
        Stack<Character> stack = new Stack<>();
        int size = arrayString.length();
        for(int i = 0; i < size; i++) {
            stack.push(arrayString.charAt(i));
        }
        arrayString= "";
        for(int i = 0; i < size; i++) {
            arrayString += stack.pop();
        }
        return arrayString;
    }

    public static void main(String[] args) {
        int [] arrayInteger = {5, 4, 3, 2, 1};
        String s = "54321";

        // Đảo ngược mảng số nguyên
        System.out.println("Mảng số nguyên trước đảo ngược là:\t");
        for(int i = 0; i < arrayInteger.length; i++) {
            System.out.print(arrayInteger[i] + "\t");
        }
        reverseInt(arrayInteger);
        System.out.println("\nMảng số nguyên sau đảo ngược là:\t");
        for(int i = 0; i < arrayInteger.length; i++) {
            System.out.print(arrayInteger[i] + "\t");
        }

        // Đảo ngược chuỗi
        System.out.println("\nChuỗi trước đảo ngược là: " + s);
        s = reverseString(s);
        System.out.println("\nChuỗi sau đảo ngược là: " + s);
    }
}
