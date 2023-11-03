package bit_manipulation.learning;

public class CheckIfOddOrNot {
    public static String oddEven(int N) {
        return (N & 1) != 0 ? "odd" : "even";
    }
}
