package binary_trees.hard;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToLeaves {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> ans = new ArrayList<>(), curr = new ArrayList<>();
        inorder(root, curr, ans);
        return ans;
    }

    static void inorder(BinaryTreeNode root, List<String> curr, List<String> ans) {
        if (root == null) return;
        curr.add(String.valueOf(root.data));
        if (root.left == null && root.right == null) {
            String s = String.join(" ", curr);
            ans.add(s);
            return;
        }
        inorder(root.left, new ArrayList<>(curr), ans);
        inorder(root.right, new ArrayList<>(curr), ans);
    }
}
