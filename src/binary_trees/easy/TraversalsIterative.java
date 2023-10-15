package binary_trees.easy;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalsIterative {
    public static void preOrder(BinaryTreeNode<Integer> root) {
        //iterative method
        if (root == null)
            return;
        Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            BinaryTreeNode<Integer> t = st.pop();
            System.out.print(t.data + " ");
            if (t.right != null)
                st.add(t.right);
            if (t.left != null)
                st.add(t.left);
        }
    }

    static List<Integer> getInOrderTraversal(TreeNode root) {
        //inorder - LPR
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode t = root;
        while (true) {
            if (t != null) {
                st.push(t);
                t = t.left;
            } else {
                if (st.isEmpty())
                    break;
                t = st.pop();
                ans.add(t.data);
                t = t.right;
            }
        }
        return ans;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.add(node);
            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }
        return ans;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        //By using one stack
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    ans.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ans;
    }

}
