package ss13_ThuatToanTimKiem.ThucHanh.BinarySearch_KhongDeQuy;

public class BinarySearch {
    static int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static int binarySearch(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;
        while (right >= left) {
            int mid = left + (right - left)/2;
            if(value < a[mid])
                right = mid - 1;
            else if(value > a[mid])
                left = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(a, 2));
    }
}
