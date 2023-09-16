package binary_search.one_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchInARotatedSortedArray {
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {12, 15, 18, 2, 4};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(12, 15, 18, 2, 4));
        System.out.println(search(al, al.size(), k));
        System.out.println(search(arr, k));
    }

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr.get(m) == k)
                return m;
            else if (arr.get(low) <= arr.get(m)) {
                if (arr.get(low) <= k && k <= arr.get(m))
                    high = m - 1;
                else
                    low = m + 1;
            } else {
                if (arr.get(m) <= k && k <= arr.get(high))
                    low = m + 1;
                else
                    high = m - 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[low] <= nums[m]) {
                if (nums[low] <= target && target <= nums[m])
                    high = m - 1;
                else
                    low = m + 1;
            } else {
                if (nums[m] <= target && target <= nums[high])
                    low = m + 1;
                else
                    high = m - 1;
            }
        }
        return -1;
    }
}
