package dynamic_programming;

import java.util.Arrays;

public class FibonacciNumberNth {
    public static void main(String[] args) {
        int n = 15;
        //By using memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getFibonacciNo(n, dp));

        //By using two variables
        int prev2 = 0, prev = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(curr);
    }

    static int getFibonacciNo(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = getFibonacciNo(n - 1, dp) + getFibonacciNo(n - 2, dp);
    }
}
