package binary_trees.medium;

import java.util.*;

class NodeHd {
    int hd;
    TreeNode node;

    public NodeHd(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

public class TopViewOfBinaryTree {
    public static List<Integer> getTopView(TreeNode root) {
        Queue<NodeHd> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new NodeHd(0, root));
        while (!q.isEmpty()) {
            NodeHd n = q.poll();
            int hd = n.hd;
            if (!map.containsKey(hd))
                map.put(hd, n.node.data);
            if (n.node.left != null)
                q.add(new NodeHd(hd - 1, n.node.left));
            if (n.node.right != null)
                q.add(new NodeHd(hd + 1, n.node.right));
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            ans.add(en.getValue());
        }
        return ans;
    }
}
