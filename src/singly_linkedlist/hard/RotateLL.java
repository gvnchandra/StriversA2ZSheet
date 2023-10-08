package singly_linkedlist.hard;


public class RotateLL {
    public static LLNode rotate(LLNode head, int k) {
        int count = 1;
        LLNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        temp.next = head;
        //the length of the linked list can be greater than the k
        k = k % count;
        int rem = count - k, c = 1;
        while (c <= rem) {
            temp = temp.next;
            c++;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
