package singly_linkedlist.medium;

public class ReverseLLRecursion {
    public static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null)
            return node;
        Node n = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return n;
    }
}
