package binary_trees.hard;

public class ChildrenSumProperty {
    public static boolean isParentSum(Node root) {
        return inorder(root) != -1;
    }

    static int inorder(Node root) {
        if (root == null)
            return 0;
        int leftSum = inorder(root.left);
        int rightSum = inorder(root.right);
        if (leftSum == -1 || rightSum == -1)
            return -1;
        if (leftSum == 0 && rightSum == 0)
            return root.data;
        if (rightSum == 0)
            return leftSum == root.data ? root.data : -1;
        if (leftSum == 0)
            return rightSum == root.data ? root.data : -1;
        return leftSum + rightSum == root.data ? root.data : -1;
    }
}
