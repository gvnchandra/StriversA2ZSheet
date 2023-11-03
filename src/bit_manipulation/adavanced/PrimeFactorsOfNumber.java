package bit_manipulation.adavanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsOfNumber {
    public static void main(String[] args) {
        int n = 35;
        System.out.println(countPrimes(n));
    }

    public static List<Integer> countPrimes(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 2)
            return ans;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (primes[p]) {
                for (int j = p * p; j <= n; j += p) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i] && n % i == 0)
                ans.add(i);
        }
        return ans;
    }
}
