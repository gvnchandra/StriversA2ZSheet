package bit_manipulation.learning;

import java.util.Arrays;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int[] a = {8};
        int[] b = {5};
        swapNumber(a, b);
        System.out.print(Arrays.toString(a));
        System.out.print(Arrays.toString(b));
    }

    public static void swapNumber(int[] a, int[] b) {
        a[0] = a[0] ^ b[0];
        b[0] = a[0] ^ b[0];
        a[0] = a[0] ^ b[0];
    }
}
