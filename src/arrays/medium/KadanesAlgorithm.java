package arrays.medium;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        System.out.println(maxSubarraySum(arr, n));
        System.out.println(maxSubarraySum2(arr, n));
    }

    public static long maxSubarraySum(int[] arr, int n) {
        //find the max sum array including empty array
        long maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0)
                sum = 0;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum < 0 ? 0 : maxSum;
    }

    public static long maxSubarraySum2(int[] arr, int n) {
        //By using divide and conquer approach
        return Math.max(0, divideAndConquer(arr, 0, n - 1));
    }

    private static long divideAndConquer(int[] arr, int l, int r) {
        if (r < l)
            return Integer.MIN_VALUE;
        if (l == r)
            return arr[l];
        int m = (l + r) / 2;
        long leftSum = divideAndConquer(arr, l, m);
        long rightSum = divideAndConquer(arr, m + 1, r);
        return Math.max(maxCrossSum(arr, l, m, r), Math.max(leftSum, rightSum));
    }

    private static long maxCrossSum(int[] arr, int l, int m, int r) {
        long sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int i = m; i <= r; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        return Math.max(leftSum + rightSum - arr[m], Math.max(leftSum, rightSum));
    }
}
