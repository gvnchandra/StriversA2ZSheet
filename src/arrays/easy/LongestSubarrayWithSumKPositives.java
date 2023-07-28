package arrays.easy;

import java.util.HashMap;

public class LongestSubarrayWithSumKPositives {
    public static void main(String[] args) {
        int n = 7, k = 3;
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        System.out.println(longestSubarrayWithSumK(arr, k));

        System.out.println(method1(arr, k));
    }

    public static int longestSubarrayWithSumK(int[] a, long k) {
        //By using two pointers approach
        int l = 0, r = 0, maxLen = 0;
        long sum = 0;
        while (r < a.length) {
            sum += a[r];
            while (sum > k && l < r) {
                sum -= a[l];
                l++;
            }
            if (sum == k)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int method1(int[] a, long k) {
        //By using prefix sum subarray
        //works for both positives and negatives
        HashMap<Long, Integer> has = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        has.put(0L, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (has.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - has.get(sum - k));
            }
            if (!has.containsKey(sum)) {
                has.put(sum, i);
            }
        }
        return maxLen;
    }
}
