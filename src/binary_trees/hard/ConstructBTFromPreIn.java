package binary_trees.hard;

import java.util.HashMap;

public class ConstructBTFromPreIn {
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        //duplicates won't exist in given tree
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildBT(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1, map);
    }

    static TreeNode buildBT(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd,
                            HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int inRoot = map.get(node.data);
        int numsLeftIn = inRoot - inStart;
        node.left = buildBT(inorder, inStart, inRoot - 1, preorder, preStart + 1,
                preStart + numsLeftIn, map);
        node.right = buildBT(inorder, inRoot + 1, inEnd, preorder,
                preStart + numsLeftIn + 1, preEnd, map);
        return node;
    }
}
