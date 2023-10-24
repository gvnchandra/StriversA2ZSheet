package binary_trees.hard;

public class CountTotalNodesInABinaryTree {

    public static int countNodes(BinaryTreeNode root) {
        //if the left and right heights are same, then calculate the nodes through the 2^level-1
        int lh = leftMostHeight(root);
        int rh = rightMostHeight(root);
        if (lh == rh)
            return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int leftMostHeight(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        int height = 0;
        while (temp != null) {
            height++;
            temp = temp.left;
        }
        return height;
    }

    static int rightMostHeight(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        int height = 0;
        while (temp != null) {
            height++;
            temp = temp.right;
        }
        return height;
    }
}
