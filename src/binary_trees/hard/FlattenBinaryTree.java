package binary_trees.hard;

public class FlattenBinaryTree {
    static TreeNode<Integer> prev = null;

    public void flatten(TreeNode root) {
//        if (root == null)
//            return;
//        flatten(root.right);  // Step 1
//        flatten(root.left);   // Step 2
//        root.right = prev;    // Step 3
//        root.left = null;     // Step 4
//        prev = root;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        if (root == null)
            return null;
        flattenBinaryTree(root.right);
        flattenBinaryTree(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }

}
