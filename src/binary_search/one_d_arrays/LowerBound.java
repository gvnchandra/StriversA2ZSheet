package binary_search.one_d_arrays;

public class LowerBound {
    public static void main(String[] args) {
        int x = 9;
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        System.out.println(lowerBound(arr, arr.length, x));
    }

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] >= x) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return low;
    }
}
