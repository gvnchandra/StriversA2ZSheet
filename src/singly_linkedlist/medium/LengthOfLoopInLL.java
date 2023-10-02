package singly_linkedlist.medium;

public class LengthOfLoopInLL {
    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null)
            return 0;
        Node slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                //cycle exists
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                int count = 1;
                while (fast.next != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return 0;
    }
}
