package ss11_Stack_Queue.Optional.BaiTap.CheckPalindrome_Queue;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class TestPalindrome {
    public static boolean checkPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        String text = s.toLowerCase();
        // Thêm vào stack và queue
        for(int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
            queue.add(text.charAt(i));
        }
        // Check stack và queue
        while (!stack.isEmpty()) {
            if(stack.peek() != queue.peek())
                return false;
            stack.pop();
            queue.remove();
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "Able was I ere I saw Elba";
        String s2 = "Able was I ere Im saw Elba";
        System.out.println(checkPalindrome(s1));
        System.out.println(checkPalindrome(s2));
    }
}
