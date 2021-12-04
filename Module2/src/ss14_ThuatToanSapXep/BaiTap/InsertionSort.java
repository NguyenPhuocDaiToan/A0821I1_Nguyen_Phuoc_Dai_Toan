package ss14_ThuatToanSapXep.BaiTap;

public class InsertionSort {
    static int[] list = {1, 3, 6, 2, 5, 9, 20, 18, 21, 17};
    public static void insertionSort(int[] list) {
        System.out.print("Bước 0: ");
        display(list);
        System.out.println();
        int size = list.length;
        for(int i = 1; i < size; i++) {
            int temp = list[i];
            int pos = i - 1;
            while(pos > 0 && temp < list[pos]) {
                list[pos + 1] = list[pos];
                pos--;
            }
            list[pos + 1] = temp;
            System.out.print("Bước " + i + ": ");
            display(list);
            System.out.println();
        }
    }
    public static void display(int[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
    public static void main(String[] args) {
        insertionSort(list);

    }
}
