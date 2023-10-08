package singly_linkedlist.hard;

public class ReverseNodesOfSizeK {
    public static Node kReverse(Node head, int k) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        Node dum = new Node(-1);
        dum.next = head;
        Node pre = dum;
        while (count >= k) {
            Node curr = pre.next, next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dum.next;
    }
}
