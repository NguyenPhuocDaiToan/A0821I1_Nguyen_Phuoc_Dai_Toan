package ss11_Stack_Queue.Optional.BaiTap.KiemTraDauNgoac_Stack;

import java.util.Stack;

public class KiemTraDauNgoac {
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == '(')
                stack.push('(');
            if(s.charAt(i) == ')')
            {
                if(stack.peek() != '(') return false;
                stack.pop();
            }
        }
        if(stack.isEmpty())     return true;
        return false;
    }
    public static void main(String[] args) {
        String[] s = {"s * (s – a) * (s – b) * (s – c)", "s * (s – a) * (s – b * (s – c)"};
        System.out.println(check(s[0]));

    }
}
