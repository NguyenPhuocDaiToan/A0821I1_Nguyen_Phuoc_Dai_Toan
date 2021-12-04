package ss11_Stack_Queue;

import java.util.Stack;
import java.util.TreeMap;

public class test {
    // Đếm kí tự
    public static void main(String[] args) {
        String s = "Hello world";
        TreeMap<Character, Integer> treeMap = new TreeMap<>(); // khởi tạo tree map rỗng
        for(int i = 0; i < s.length(); i++) {
            // Nếu tồn tại => tăng số lượng lên 1
            if(treeMap.containsKey(s.charAt(i))) {
                treeMap.put(s.charAt(i), treeMap.get(s.charAt(i)) + 1);
            }
            // chưa thì gán bằng 1
            else treeMap.put(s.charAt(i), 1);
        }
        System.out.println(treeMap);
    }
}
