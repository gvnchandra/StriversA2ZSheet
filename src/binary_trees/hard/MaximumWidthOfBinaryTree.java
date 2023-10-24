package binary_trees.hard;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode<>(4);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        tree.left.left.right = new TreeNode(7);
        System.out.print(widthOfBinaryTree(tree));
    }

    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            ans = Math.max(ans, n);
            for (int i = 1; i <= n; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return ans;
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if (root == null)
            return 0;
        int ans = 1;
        q.add(new Pair(root, 1));
        while (!q.isEmpty()) {
            int n = q.size();
            int minInd = q.peek().index;
            int first = 0, last = 0;
            for (int i = 1; i <= n; i++) {
                int currInd = q.peek().index - minInd;
                if (i == 1)
                    first = q.peek().index;
                if (i == n)
                    last = q.peek().index;
                Pair pair = q.poll();
                TreeNode node = pair.node;
                if (node.left != null)
                    q.add(new Pair(node.left, 2 * currInd + 1));
                if (node.right != null)
                    q.add(new Pair(node.right, 2 * currInd + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
