package singly_linkedlist.medium;


public class SortLL {
    public static Node sortList(Node head) {
        Node even = new Node(-1), odd = new Node(-1);
        Node evenTail = even, oddTail = odd;
        Node temp = head;
        boolean flagOddInd = true;
        while (temp != null) {
            if (flagOddInd) {
                oddTail.next = temp;
                oddTail = oddTail.next;
            } else {
                evenTail.next = temp;
                evenTail = evenTail.next;
            }
            flagOddInd = !flagOddInd;
            temp = temp.next;
        }
        oddTail.next = null;
        evenTail.next = null;
        return merge(odd.next, reverse(even.next));
    }

    static Node merge(Node h1, Node h2) {
        Node head = new Node(-1), temp = head;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        while (h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }
        while (h2 != null) {
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }
        return head.next;
    }

    static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
