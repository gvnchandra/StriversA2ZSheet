package binary_trees.easy;

public class NumberOfNodes {
    public static int numberOfNodes(int N) {
        return (int) Math.pow(2, N - 1);
    }
}
