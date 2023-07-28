package arrays.easy;

import java.util.HashMap;

public class LongestSubarrayWithSumKPositivesAndNegatives {
    public static void main(String[] args) {
        int n = 3, k = 5;
        int[] arr = {2, 3, 5};
        System.out.println(getLongestSubarray(arr, k));
    }

    public static int getLongestSubarray(int[] a, int k) {
        //By using prefix sum subarray
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
