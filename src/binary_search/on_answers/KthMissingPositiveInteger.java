package binary_search.on_answers;

public class KthMissingPositiveInteger {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {2, 5, 6, 7, 9, 10};
        System.out.println(missingK(arr, arr.length, k));
    }

    public static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (k <= vec[mid] - (mid + 1))
                high = mid - 1;
            else
                low = mid + 1;
        }
        //return vec[high] + k - (vec[high] - (high + 1));
        return low + k; // By simplifying above formula
    }
}
