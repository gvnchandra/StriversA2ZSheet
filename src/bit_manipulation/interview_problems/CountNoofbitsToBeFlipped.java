package bit_manipulation.interview_problems;

public class CountNoofbitsToBeFlipped {
    public static void main(String[] args) {
        int x = 7, y = 12;
        System.out.print(flipBits(x, y));
    }

    public static int flipBits(int A, int B) {
        int xor = A ^ B, count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1)
                count++;
            xor >>= 1;
        }
        return count;
    }
}
