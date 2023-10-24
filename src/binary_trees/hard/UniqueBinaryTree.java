package binary_trees.hard;

public class UniqueBinaryTree {
    public static boolean uniqueBinaryTree(int a, int b) {
        if (a == b)
            return false;
        else return a == 2 || b == 2;
    }
}
