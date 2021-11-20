package ss11_Stack_Queue.Optional.BaiTap.ConvertDecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thập phân cần chuyển đổi: ");
        n = scanner.nextInt();
        while(n!=0) {
            stack.push(n%2);
            n /= 2;
        }
        System.out.print("Số nhị phân sau khi chuyển đổi là: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
