package bit_manipulation.learning;

public class CountNoOfSetBits {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(method1(n));
        System.out.print(countSetBits(n));
    }

    public static int countSetBits(int n) {
        if (n==0)
            return 0;
        int pow = maxpow(n);
        int x = pow * (1 << (pow - 1));
        int y = n - (1 << pow);
        return x + y + 1 + countSetBits(y);
    }

    static int maxpow(int n) {
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;
    }

    public static int method1(int n) {
        int[] bits = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) != 0)
                bits[i] = 1 + bits[i / 2];
            else
                bits[i] = bits[i / 2];
            sum += bits[i];
        }
        return sum;
    }
}
