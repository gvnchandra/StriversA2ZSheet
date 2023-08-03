package arrays.hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 0};
        System.out.println(subarrayWithMaxProduct(arr));
    }

    public static int subarrayWithMaxProduct(int[] arr) {
        // Write your code here.
        int ans = Integer.MIN_VALUE, pre = 1, suf = 1, n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            pre = pre * arr[i];
            suf = suf * arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suf));
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
        }
        return ans;
    }
}
