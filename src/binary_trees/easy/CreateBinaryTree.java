package binary_trees.easy;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTree {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        TreeNode root = buildTree(nums);
        inorder(root);
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static TreeNode createTree(int[] arr) {
        return insertNode(arr, 0);
    }

    static TreeNode insertNode(int[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            root.left = insertNode(arr, 2 * i + 1);
            root.right = insertNode(arr, 2 * i + 2);
        }
        return root;
    }

    public static TreeNode buildTree(int[] nums) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        q.add(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode n = q.remove();
            n.left = new TreeNode(nums[i++]);
            q.add(n.left);
            if (i < nums.length) {
                n.right = new TreeNode(nums[i++]);
                q.add(n.right);
            }
        }
        return root;
    }
}
