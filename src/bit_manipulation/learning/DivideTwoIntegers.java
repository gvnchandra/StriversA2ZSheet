package bit_manipulation.learning;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int divisor = 7, dividend = 24;
        System.out.print(divideTwoInteger(dividend, divisor));
    }

    public static int divideTwoInteger(int dividend, int divisor) {
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int ans = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int tmp = divisor, q = 1;
            while (tmp <= dividend) {
                tmp <<= 1;
                q <<= 1;
            }
            ans += q >> 1;
            dividend -= tmp >> 1;
        }
        if (isNeg)
            return ~ans + 1;
        else
            return ans;
    }
}
