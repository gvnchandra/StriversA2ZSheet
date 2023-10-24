package binary_trees.hard;

import java.util.ArrayList;

public class PrintRootToNodePath {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(6);
        root.left.right.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(3);
        ArrayList<Integer> arr = new ArrayList<>();
        boolean res = getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it : arr) {
            System.out.print(it + " ");
        }

    }

    static boolean getPath(BinaryTreeNode root, ArrayList<Integer> arr, int x) {
        if (root == null)
            return false;
        arr.add(root.data);
        if (root.data == x)
            return true;
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;
        arr.remove(arr.size() - 1);
        return false;
    }

}
