package binary_search.on_answers;

import java.util.ArrayList;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(largestSubarraySumMinimized(ar, k));
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        //By using binary search
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            sum += a[i];
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = f(a, mid);
            if (count <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int f(int[] al, int mid) {
        int noOfSubarrays = 1, sum = 0;
        for (int i = 0; i < al.length; i++) {
            if (al[i] + sum <= mid) {
                sum += al[i];
            } else {
                noOfSubarrays++;
                sum = al[i];
            }
        }
        return noOfSubarrays;
    }
}
