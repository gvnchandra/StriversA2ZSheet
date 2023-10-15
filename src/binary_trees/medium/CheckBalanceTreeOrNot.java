package binary_trees.medium;

public class CheckBalanceTreeOrNot {
    public static boolean isBalancedBT(TreeNode root) {
        return check(root) != -1;
    }

    static int check(TreeNode root) {
        if (root == null)
            return 0;
        int lh = check(root.left);
        if (lh == -1)
            return -1;
        int rh = check(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

    public static boolean isBalancedBT2(TreeNode root) {
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1)
            return false;
        boolean left = isBalancedBT2(root.left);
        boolean right = isBalancedBT2(root.right);
        return left && right;
    }

    static int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
