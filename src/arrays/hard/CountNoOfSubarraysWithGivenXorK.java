package arrays.hard;

import java.util.HashMap;

public class CountNoOfSubarraysWithGivenXorK {
    public static void main(String[] args) {
        int n = 4, k = 2;
        int[] arr = {1, 2, 3, 2};
        System.out.println(subarraysWithSumK(arr, k));
    }

    public static int subarraysWithSumK(int[] a, int b) {
        // Write your code here
        //By using prefix xors
        int xor = 0, ans = 0;
        HashMap<Integer, Integer> xorCounts = new HashMap<>();
        xorCounts.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
            if (xorCounts.containsKey(xor ^ b)) {
                ans += xorCounts.get(xor ^ b);
            }
            xorCounts.put(xor, xorCounts.getOrDefault(xor, 0) + 1);
        }
        return ans;
    }
}
