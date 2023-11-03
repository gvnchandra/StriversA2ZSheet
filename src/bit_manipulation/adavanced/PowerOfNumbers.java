package bit_manipulation.adavanced;

public class PowerOfNumbers {
    public static int power(int N, int R) {
        long ans = 1, base = N;
        int mod = 1000000007;
        while (R > 0) {
            if ((R & 1) != 0) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            R /= 2;
        }
        return (int) ans;
    }

    public double myPow(double x, int n) {
        if (x == 1)
            return x;
        // By using Binary Exponentiation
        double ans = 1.0;
        int nSign = 1 - 2 * (n > 0 ? 0 : 1);
        if (nSign < 0)
            n *= nSign;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            x *= x;
            n /= 2;
        }
        return nSign < 0 ? 1 / ans : ans;
    }
}
