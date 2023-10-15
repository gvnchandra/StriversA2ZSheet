package binary_trees.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    int getMaxWidth1(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);
            while (count > 0) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                count--;
            }
        }
        return maxWidth;
    }

    int getMaxWidth(TreeNode root) {
        //By using preorder traversal
        int h = height(root);
        int[] count = new int[h];

        int level = 0;
        preorder(root, level, count);
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max)
                max = count[i];
        }
        return max;
    }

    static void preorder(TreeNode root, int level, int[] count) {
        if (root == null)
            return;
        count[level]++;
        preorder(root.left, level + 1, count);
        preorder(root.right, level + 1, count);
    }

    static int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
