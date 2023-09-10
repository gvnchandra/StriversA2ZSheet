package arrays.hard;

import java.util.Arrays;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 2};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }

    public static int[] findMissingRepeatingNumbers(int[] a) {
        // Write your code here
        //By using xor
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
            xor ^= (i + 1);
        }
//        int bitNo = 0;
//        while ((xor & (1 << bitNo)) == 0) {
//            bitNo++;
//        }
        int number = xor & -xor;
        int zero = 0, ones = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & number) != 0)
                ones ^= a[i];
            else
                zero ^= a[i];
        }
        for (int i = 1; i <= a.length; i++) {
            if ((i & number) != 0)
                ones ^= i;
            else
                zero ^= i;
        }
        int co = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == zero)
                co++;
        }
        int[] ans = new int[2];
        if (co == 2) {
            ans[0] = zero;
            ans[1] = ones;
        } else {
            ans[0] = ones;
            ans[1] = zero;
        }
        return ans;
    }
}
