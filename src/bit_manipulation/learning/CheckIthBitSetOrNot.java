package bit_manipulation.learning;

public class CheckIthBitSetOrNot {
    static boolean isKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }
}
