package bit_manipulation.learning;

import java.util.Arrays;

public class BitManipulation {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(bitManipulation(25, 3)));
    }

    public static int[] bitManipulation(int num, int i) {
        int[] ans = new int[3];
        ans[0] = (num & (1 << (i - 1))) != 0 ? 1 : 0;
        //setting bit at i
        ans[1] = num | (1 << (i - 1));
        //clearing bit at i
        ans[2] = num & ~(1 << (i - 1));
        return ans;
    }
}
