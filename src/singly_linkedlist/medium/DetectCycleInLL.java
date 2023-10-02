package singly_linkedlist.medium;

public class DetectCycleInLL {
    public static boolean detectCycle(Node head) {
        if (head==null || head.next == null)
            return false;
        Node slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
