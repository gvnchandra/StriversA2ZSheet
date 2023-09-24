package binary_search.on_answers;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        long n=7;
        System.out.println(sqrtN(n));
    }

    public static int sqrtN(long n) {
        long low = 1, high = n;
        while (low <= high) {
            long m = (low + high) / 2;
            if (m * m == n)
                return (int) m;
            else if (m * m > n)
                high = m - 1;
            else
                low = m + 1;
        }
        return (int) high;
    }
}
