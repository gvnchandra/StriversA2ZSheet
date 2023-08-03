package arrays.medium;

import java.util.HashMap;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        System.out.println(findAllSubarraysWithGivenSum(arr, k));
    }

    public static int findAllSubarraysWithGivenSum(int[] arr, int s) {
        //By using prefix sum subarray
        HashMap<Integer, Integer> sumCounts = new HashMap<>();
        int sum = 0, ans = 0;
        sumCounts.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumCounts.containsKey(sum - s)) {
                ans += sumCounts.get(sum - s);
            }
            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static int method1(int arr[], int s) {
        // Write your code here.
        //This works if array elements are +ve.
        int sum = 0, l = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > s) {
                sum -= arr[l];
                l++;
            }
            if (sum == s) {
                ans++;
            }
        }
        return ans;
    }
}
