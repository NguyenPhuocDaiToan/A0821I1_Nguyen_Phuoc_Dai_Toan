package ss14_ThuatToanSapXep.ThucHanh;

public class BubbleSortByStep {
    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 8, 7, 20, 19, 18, 30};
        displayArray(a);
        System.out.println("Các bước sort là: ");
        bubbleSortByStep(a);
        System.out.println("Mảng sau khi sắp xếp là: ");
        displayArray(a);
    }
    public static void bubbleSortByStep(int [] a) {
        boolean isSwap;
        for(int i = 0; i < a.length - 1; i++) {
            isSwap = false;
            for(int j = a.length - 1; j > i; j--) {
                if(a[j] < a[j-1]) {
                    System.out.println("Swap " + a[j] + " with " + a[j-1]);
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap) {
                System.out.println("Mảng đã sort.");
                break;
            }
        }
    }
    public static void displayArray(int[] a) {
        int size = a.length;
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
