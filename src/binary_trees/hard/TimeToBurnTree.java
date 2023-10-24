package binary_trees.hard;

import java.util.*;

public class TimeToBurnTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
//        root.left = new BinaryTreeNode(2);
//        root.right = new BinaryTreeNode(3);
//        root.left.left = new BinaryTreeNode(4);
//        root.left.right = new BinaryTreeNode(5);
//        root.left = new BinaryTreeNode(2);
//        root.left.left = new BinaryTreeNode(3);
//        root.left.left.right = new BinaryTreeNode(4);
//        root.left.left.right.left = new BinaryTreeNode(5);
//        root.left.left.right.left.right = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.left.left = new BinaryTreeNode(3);
        root.left.right.left = new BinaryTreeNode(5);
        System.out.print(timeToBurnTree(root, 3));
    }

    public static int timeToBurnTree(BinaryTreeNode root, int start) {
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        BinaryTreeNode target = null;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.data == start)
                target = node;
            if (node.left != null) {
                q.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parent.put(node.right, node);
            }
        }
        int dis = 0;
        List<BinaryTreeNode> vis = new ArrayList<>();
        q.add(target);
        while (!q.isEmpty()) {
            int n = q.size();
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                BinaryTreeNode node = q.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                    flag = true;
                }
                if (node.right != null && !vis.contains(node.right)) {
                    q.add(node.right);
                    vis.add(node.right);
                    flag = true;
                }
                if (parent.get(node) != null && !vis.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    vis.add(parent.get(node));
                    flag = true;
                }
            }
            if (flag)
                dis++;
        }
        return dis;
    }
}
