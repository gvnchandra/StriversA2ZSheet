package singly_linkedlist.medium;

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
