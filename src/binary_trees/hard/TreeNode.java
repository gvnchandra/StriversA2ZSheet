package binary_trees.hard;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}