package singly_linkedlist.medium;

public class DeleteMiddleNode {
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null)
            return null;
        Node prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
