package arrays.medium;

public class PrintSubarrayWithMaxSumSubarray {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubarraySum(arr, n);
    }

    public static void maxSubarraySum(int[] arr, int n) {
        //find the max sum array including empty array
        long maxSum = Integer.MIN_VALUE, sum = 0;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
            if (sum > maxSum) {
                maxSum = sum;
                end = i;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
