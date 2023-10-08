package singly_linkedlist.medium;

public class SortLL0s1s2s {
    public static Node sortList(Node head) {
        Node one = new Node(-1), zero = new Node(-1), two = new Node(-1);
        Node onet = one, twot = two, zerot = zero;
        while (head != null) {
            if (head.data == 0) {
                zerot.next = head;
                zerot = zerot.next;
            } else if (head.data == 1) {
                onet.next = head;
                onet = onet.next;
            } else {
                twot.next = head;
                twot = twot.next;
            }
            head = head.next;
        }
        twot.next = null;
        zerot.next = one.next;
        onet.next = two.next;
        return zero.next;
    }
}
