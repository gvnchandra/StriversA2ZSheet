package binary_trees.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                ans.add(curr.data);
                if (curr.left != null)
                    curr = curr.left;
                else
                    curr = curr.right;
            } else
                break;
        }
    }

    static void addRightBoundary(TreeNode root, List<Integer> ans) {
        Stack<Integer> temp = new Stack<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.push(curr.data);
                if (curr.right != null)
                    curr = curr.right;
                else
                    curr = curr.left;
            } else
                break;
        }
        while (!temp.isEmpty()) {
            ans.add(temp.pop());
        }
    }

    static void addLeaves(TreeNode root, List<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, ans);
        if (root.right != null) addLeaves(root.right, ans);
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root))
            ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
}
