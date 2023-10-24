package binary_trees.hard;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static List<Integer> getInOrderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                ans.add((Integer) curr.data);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ans.add((Integer) curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
