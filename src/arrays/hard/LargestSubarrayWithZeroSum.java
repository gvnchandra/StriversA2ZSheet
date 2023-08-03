package arrays.hard;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, -1, 0, 0, 1};
        System.out.println(getLongestZeroSumSubarrayLength(arr));
    }

    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        // Write your code here.
        HashMap<Integer, Integer> has = new HashMap<>();
        has.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (has.containsKey(sum))
                ans = Math.max(ans, i - has.get(sum));
            else
                has.put(sum, i);
        }
        return ans;
    }
}
