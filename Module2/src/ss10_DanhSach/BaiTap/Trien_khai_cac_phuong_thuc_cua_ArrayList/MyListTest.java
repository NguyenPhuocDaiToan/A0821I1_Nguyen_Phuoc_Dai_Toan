package ss10_DanhSach.BaiTap.Trien_khai_cac_phuong_thuc_cua_ArrayList;

public class MyListTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyList<String> test = new MyList<>();
        test.add("Hello");
        test.add("World");

        try {
            MyList<String> arrayClone = (MyList<String>) test.clone();
            for (int i = 0; i < arrayClone.size(); i++) {
                System.out.println(arrayClone.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
