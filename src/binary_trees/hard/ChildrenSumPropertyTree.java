package binary_trees.hard;

public class ChildrenSumPropertyTree {

    public static void isParentSum(Node root) {
        if (root == null)
            return;
        int child = 0;
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;
        if (child >= root.data) root.data = child;
        else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }
        isParentSum(root.left);
        isParentSum(root.right);
        int tot = 0;
        if (root.left != null) tot += root.left.data;
        if (root.right != null) tot += root.right.data;
        if (root.left != null || root.right != null)
            root.data = tot;
    }

}
