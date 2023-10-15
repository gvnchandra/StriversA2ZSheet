package binary_trees.medium;

import java.util.*;

class Tuple {
    TreeNode node;
    int x, y;

    public Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

public class VerticalOrderTraversal {
    public static List<Integer> verticalOrderTraversal(TreeNode root) {
        if (root == null)
            return null;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tree = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int x = temp.x, y = temp.y;
            if (!tree.containsKey(x))
                tree.put(x, new TreeMap<>());
            if (!tree.get(x).containsKey(y))
                tree.get(x).put(y, new PriorityQueue<>());
            tree.get(x).get(y).add(node.data);
            if (node.left != null)
                q.add(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.add(new Tuple(node.right, x + 1, y + 1));
        }
        List<Integer> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> y : tree.values()) {
            for (PriorityQueue<Integer> pq : y.values()) {
                while (!pq.isEmpty()) {
                    ans.add(pq.poll());
                }
            }
        }
        return ans;
    }
}
