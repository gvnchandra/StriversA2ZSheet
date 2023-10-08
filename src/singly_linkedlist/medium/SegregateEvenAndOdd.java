package singly_linkedlist.medium;

public class SegregateEvenAndOdd {
    public static Node segregateEvenOdd(Node head) {
        Node deven = new Node(-1), dodd = new Node(-1);
        Node evenTail = deven, oddTail = dodd;
        while (head != null) {
            if (head.data % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }
        evenTail.next = dodd.next;
        oddTail.next = null;
        return deven.next;
    }

    public Node oddEvenList(Node head) {
        Node curr = head;
        boolean odd = true;
        Node deven = new Node(-1), dodd = new Node(-1);
        Node evenTail = deven, oddTail = dodd;
        while (curr != null) {
            if (odd) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            odd = !odd;
            curr = curr.next;
        }
        oddTail.next = deven.next;
        evenTail.next = null;
        return dodd.next;
    }
}
