package binary_trees.hard;


public class LCAOfBinaryTree {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        TreeNode<Integer> node = lca(root, x, y);
        return node.data;
    }

    static TreeNode<Integer> lca(TreeNode<Integer> root, int x, int y) {
        if (root == null)
            return null;
        if (root.data == x || root.data == y)
            return root;
        TreeNode<Integer> left = lca(root.left, x, y);
        TreeNode<Integer> right = lca(root.right, x, y);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
