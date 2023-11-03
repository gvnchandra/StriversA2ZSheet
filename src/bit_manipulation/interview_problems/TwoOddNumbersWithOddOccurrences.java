package bit_manipulation.interview_problems;

import java.util.Arrays;

public class TwoOddNumbersWithOddOccurrences {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 2, 4};
        System.out.println(Arrays.toString(twoOddNum(arr)));
    }

    public static int[] twoOddNum(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int no = xor & -xor, x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & no) == 0)
                x ^= arr[i];
            else
                y ^= arr[i];
        }
        return new int[]{Math.max(x, y), Math.min(x, y)};
    }
}
