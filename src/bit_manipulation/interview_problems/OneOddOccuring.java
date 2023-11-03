package bit_manipulation.interview_problems;

public class OneOddOccuring {
    public static int missingNumber(int n, int[] arr) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}
