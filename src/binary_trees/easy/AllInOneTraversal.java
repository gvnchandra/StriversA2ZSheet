package binary_trees.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    TreeNode node;
    int num;

    public Node(TreeNode t, int num) {
        this.node = t;
        this.num = num;
    }
}

public class AllInOneTraversal {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(new Node(root, 1));
        while (!st.isEmpty()) {
            Node t = st.pop();
            if (t.num == 1) {
                preorder.add(t.node.data);
                t.num += 1;
                st.push(t);
                if (t.node.left != null) {
                    st.push(new Node(t.node.left, 1));
                }
            } else if (t.num == 2) {
                inorder.add(t.node.data);
                t.num += 1;
                st.push(t);
                if (t.node.right != null) {
                    st.push(new Node(t.node.right, 1));
                }
            } else {
                postorder.add(t.node.data);
            }
        }
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;
    }
}
