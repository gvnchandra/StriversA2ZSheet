package bit_manipulation.learning;

public class PowerOf2OrNot {
    public static void main(String[] args) {
        int n = 10;
        System.out.print(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
//        int val = 0, i = 0;
//        while (val <= n) {
//            val = 1 << i;
//            if (val == n)
//                return true;
//            i++;
//        }
//        return false;
        return n > 0 && (n & (n - 1)) == 0;
    }
}
