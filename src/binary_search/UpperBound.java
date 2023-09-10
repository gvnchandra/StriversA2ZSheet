package binary_search;

public class UpperBound {
    public static void main(String[] args) {
        int x = 5;
        int[] arr = {2, 4, 6, 5};
        System.out.println(upperBound(arr, x, arr.length));
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] > x) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return low;
    }
}
