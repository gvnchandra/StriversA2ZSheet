package singly_linkedlist.medium;

public class IntersectionOfLLs {
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node p1 = firstHead, p2 = secondHead;
        while (p1 != p2) {
            p1 = (p1 == null) ? secondHead : p1.next;
            p2 = (p2 == null) ? firstHead : p2.next;
        }
        return p1.data;
    }
}
