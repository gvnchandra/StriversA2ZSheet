package binary_trees.hard;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(10);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(16);
        root.left.left.left.left = new TreeNode(12);
        root.left.left.left.left.left = new TreeNode(12);
        String ser = serializeTree(root);
        System.out.println(ser);
        deserializeTree(ser);
    }

    public static String serializeTree(TreeNode root) {
        //By using level order traversal
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder ser = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                ser.append("# ");
                continue;
            }
            ser.append(temp.data).append(" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        return ser.toString();
    }

    public static TreeNode deserializeTree(String serialized) {
        if (serialized == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = serialized.split(" ");
        int ind = 0;
        TreeNode root = getTreeNode(arr, ind);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode rem = q.poll();
            ind++;
            if (ind < arr.length && !arr[ind].equals("#")) {
                TreeNode left = getTreeNode(arr, ind);
                q.add(left);
                rem.left = left;
            }
            ind++;
            if (ind < arr.length && !arr[ind].equals("#")) {
                TreeNode right = getTreeNode(arr, ind);
                q.add(right);
                rem.right = right;
            }
        }
        return root;
    }

    static TreeNode getTreeNode(String[] ser, int ind) {
        return new TreeNode(Integer.parseInt(ser[ind]));
    }
}
