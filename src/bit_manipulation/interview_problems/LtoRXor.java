package bit_manipulation.interview_problems;

public class LtoRXor {
    public static void main(String[] args) {
        int L = 1, R = 9;
        System.out.println(findXOR(L, R));
    }

    public static int findXOR(int L, int R) {
//        int xor = 0;
//        for (int i = L; i <= R; i++) {
//            xor ^= i;
//        }
//        return xor;
        return xor(L - 1) ^ xor(R);
    }

    static int xor(int n) {
        if (n % 4 == 1)
            return 1;
        else if (n % 4 == 2)
            return n + 1;
        else if (n % 4 == 3)
            return 0;
        else
            return n;
    }
}
