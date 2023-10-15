package binary_trees.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    public static void printLeftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = q.poll();
                if (i == 1)
                    System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
}
