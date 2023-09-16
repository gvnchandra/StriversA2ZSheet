package binary_search.one_d_arrays;

public class countOfOccurrences {
    public static void main(String[] args) {
        int x = 3;
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(count(arr, arr.length, x));
    }

    static int lowerBound(int[] arr, int k) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] >= k) {
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int k) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] > k) {
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        //By using binary search lower bound and upperbound
        int lb = lowerBound(arr, k);
        int ub = upperBound(arr, k);
        if (lb == n || arr[lb] != k)
            return new int[]{-1, -1};
        return new int[]{lb, ub - 1};
    }

    public static int count(int[] arr, int n, int x) {
        int[] ans = firstAndLastPosition(arr, n, x);
        if (ans[0] == -1) return 0;
        return ans[1] - ans[0] + 1;
    }
}
