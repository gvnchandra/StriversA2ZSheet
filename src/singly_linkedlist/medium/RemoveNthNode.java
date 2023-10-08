package singly_linkedlist.medium;

public class RemoveNthNode {
    public static Node removeKthNode(Node head, int K) {
        Node dum = new Node(-1);
        dum.next = head;
        Node slow = dum, fast = dum;
        int i = 1;
        while (i <= K) {
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dum.next;
    }
}
