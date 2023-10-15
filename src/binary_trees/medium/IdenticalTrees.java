package binary_trees.medium;

import java.util.Objects;

public class IdenticalTrees {
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        if (!Objects.equals(root1.data, root2.data))
            return false;
        boolean left = identicalTrees(root1.left, root2.left);
        boolean right = identicalTrees(root1.right, root2.right);
        return left && right;
    }
}
