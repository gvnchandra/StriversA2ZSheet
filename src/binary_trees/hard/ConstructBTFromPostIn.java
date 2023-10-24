package binary_trees.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBTFromPostIn {
    public static void main(String[] args) {
        int[] postorder = new int[]{2, 9, 3, 6, 10, 5};
        int[] inorder = new int[]{2, 6, 3, 9, 5, 10};
        TreeNode root = getTreeFromPostorderAndInorder(postorder, inorder);
        print(root);
    }

    static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return buildBT(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1, map);
    }

    static TreeNode buildBT(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                            HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(node.data);
        int numsLeftIn = inRoot - inStart;
        node.left = buildBT(inorder, inStart, inRoot - 1, postorder, postStart,
                postStart + numsLeftIn - 1, map);
        node.right = buildBT(inorder, inRoot + 1, inEnd, postorder,
                postStart + numsLeftIn, postEnd - 1, map);
        return node;
    }
}
