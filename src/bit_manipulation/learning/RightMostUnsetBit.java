package bit_manipulation.learning;

public class RightMostUnsetBit {
    public static void main(String[] args) {
        int n = 5;
        System.out.print(setBits(n));
    }

    public static int setBits(int N) {
        int nn = N, bitPos = -1;
        while (nn > 0) {
            bitPos++;
            if ((nn & 1) == 0)
                break;
            nn = nn >> 1;
        }
        return N | (1 << bitPos);
    }
}
