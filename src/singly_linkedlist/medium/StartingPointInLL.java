package singly_linkedlist.medium;

public class StartingPointInLL {
    public static Node firstNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                //cycle exists
                Node x = head;
                while (x != slow) {
                    x = x.next;
                    slow = slow.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
