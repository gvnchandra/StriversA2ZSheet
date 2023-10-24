package binary_trees.hard;

import java.util.*;

public class PrintNodesAtDistanceK {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(1);
        root.left.left = new BinaryTreeNode(6);
        root.left.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(0);
        root.right.right = new BinaryTreeNode(8);
        root.left.right.left = new BinaryTreeNode(7);
        root.left.right.right = new BinaryTreeNode(4);
        System.out.print(printNodesAtDistanceK(root, root.left, 2));
    }

    public static List<BinaryTreeNode> printNodesAtDistanceK(BinaryTreeNode root, BinaryTreeNode target, int K) {
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parent.put(node.right, node);
            }
        }

        List<BinaryTreeNode> ans = new ArrayList<>();
        List<BinaryTreeNode> vis = new ArrayList<>();
        int dis = 0;
        q.add(target);
        vis.add(target);
        while (!q.isEmpty()) {
            if (dis == K)
                break;
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                BinaryTreeNode node = q.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    q.add(node.right);
                    vis.add(node.right);
                }
                if (parent.get(node) != null && !vis.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    vis.add(parent.get(node));
                }
            }
            dis++;
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}
