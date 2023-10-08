package binary_trees.easy;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>(), pre = new ArrayList<>(), post = new ArrayList<>();
        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }

    static void inorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    static void preorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    static void postorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

}
