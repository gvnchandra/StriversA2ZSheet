package binary_trees.medium;

public class MaximumPathSum {
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        maxSum(root, sum);
        return sum[0];
    }

    static int maxSum(BinaryTreeNode<Integer> root, int[] sum) {
        if (root == null) return 0;
        int lsum = Math.max(0, maxSum(root.left, sum));
        int rsum = Math.max(0, maxSum(root.right, sum));
        sum[0] = Math.max(sum[0], lsum + rsum + root.data);
        return root.data + Math.max(lsum, rsum);
    }
}
