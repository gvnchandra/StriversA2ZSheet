package arrays.easy;

public class CheckForSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isSorted(arr.length, arr));
    }

    public static int isSorted(int n, int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return 0;
        }
        return 1;
    }
}
