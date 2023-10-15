package binary_trees.medium;


public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        //the diameter of binary tree can be one of the following quantities
        //left subtree diameter
        //right subtree diameter
        //the longest path of nodes blw leaves that pass through root
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    static int height(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ld = diameterOfBinaryTree2(root.left);
        int rd = diameterOfBinaryTree2(root.right);
        return Math.max(1 + lh + rh, Math.max(ld, rd));
    }

    static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
