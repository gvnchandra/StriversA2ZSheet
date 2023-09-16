package binary_search.one_d_arrays;

public class MinInSortedArray {
    public static void main(String[] args) {
        int[] arr = {25, 30, 5, 10, 15, 20};
        System.out.println(findMin(arr));
    }

    static int binarySearch(int[] arr, int low, int high) {
        if (low <= high) {
            if (arr[low] <= arr[high])
                return arr[low];
            int m = (low + high) / 2;
            if (arr[low] <= arr[m]) {
                return Math.min(arr[low], binarySearch(arr, m + 1, high));
            } else {
                return Math.min(arr[m], binarySearch(arr, low, m - 1));
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int findMin(int[] arr) {
        return binarySearch(arr, 0, arr.length - 1);
    }
}
