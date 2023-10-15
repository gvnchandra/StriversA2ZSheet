package binary_trees.medium;

public class SymmetricBinaryTree {
    static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        if (root1.data != root2.data)
            return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return isMirror(root.left, root.right);
    }
}
