package ss11_Stack_Queue.BaiTap.DemSoLanXuatHienMoiTu_Map;


import java.util.Iterator;
import java.util.TreeMap;

public class main {
    public static TreeMap<String, Integer> countWord(String s) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String text = s.toLowerCase();
        int length = s.length();
        String word = "";
        for(int i = 0; i < length; i++) {
            if(text.charAt(i) != ' ')     word += text.charAt(i);
            if(text.charAt(i) == ' ' || i == length - 1) {
                if(map.containsKey(word))
                    map.replace(word, map.get(word) + 1);
                else map.put(word, 1);
                word = "";
            }
        }
        return map;
    }
    public static void main(String args[]) {
        // khoi tao map
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String s = "        Chương trình đếm các          lần xuất hiện của từ         trong một văn bản và hiển thị " +
                "các từ và sự xuất hiện của chúng theo     thứ tự trong bảng chữ cái của         các từ";
        s = s.replaceAll("\\s\\s+", " ").trim();
        map =  countWord(s);
        //System.out.println(map);
        map.forEach((keyInt, valueInt) -> System.out.println(
                "Key = " + keyInt + ", value = " + valueInt));
    }
}
