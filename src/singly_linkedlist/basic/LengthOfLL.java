package singly_linkedlist.basic;

public class LengthOfLL {
    public static int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
