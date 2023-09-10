package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int n = 4, target = -294967296;
        int[] arr = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(arr, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int l = n - 1; l >= 3; l--) {
            if (l == n - 1 || (l < n - 1 && nums[l] != nums[l + 1])) {
                for (int k = n - 2; k >= 2; k--) {
                    if (k == l - 1 || (k < l - 1 && nums[k] != nums[k + 1])) {
                        int i = 0, j = k - 1;
                        while (i < j) {
                            long sum = nums[i] + nums[j];
                            sum += nums[k] + nums[l];
                            if (sum == target) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                while (i < j && nums[i] == nums[i + 1]) i++;
                                while (i < j && nums[j] == nums[j - 1]) j--;
                                i++;
                                j--;
                            } else if (sum > target) {
                                j--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
