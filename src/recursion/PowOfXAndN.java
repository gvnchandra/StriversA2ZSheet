package recursion;

public class PowOfXAndN {
    public static void main(String[] args) {
        double x = 1.0 ;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x==1)
            return x;
        // By using Binary Exponentiation
        double ans = 1.0;
        int nSign = 1 - 2 * (n > 0 ? 0 : 1);
        if (nSign<0)
            n*=nSign;
        while (n != 0) {
            if ((n & 1) == 0) {
                x = x * x;
                n /= 2;
            } else {
                ans = ans * x;
                n -= 1;
            }
        }
        return nSign<0? 1/ans:ans;
    }

    public static double method1(double x, int n) {
        // Write Your Code Here
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= x;
        }
        return (ans);
    }
}
