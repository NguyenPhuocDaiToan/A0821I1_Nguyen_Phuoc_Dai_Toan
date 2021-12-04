package ss14_ThuatToanSapXep.ThucHanh;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void bubbleSort(int [] list) {
        boolean isSwap;
        for(int i = 0; i < list.length - 1; i++) {
            isSwap = false;
            for(int j = list.length - 1; j > i; j--) {
                if(list[j] < list[j-1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap)  break;
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
