package ss14_ThuatToanSapXep.ThucHanh;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void selectionSort(double[] list) {
        int size = list.length;
        for (int i = 0; i < size - 1; i++) {
            double min = list[i];
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (list[j] < min) {
                    min = list[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
