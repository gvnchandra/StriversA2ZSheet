package bit_manipulation.adavanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(sieve(n));
    }

    static List<Integer> sieve(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 2)
            return ans;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (primes[p]) {
                for (int k = p * p; k <= n; k += p) {
                    primes[k] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i])
                ans.add(i);
        }
        return ans;
    }
}
