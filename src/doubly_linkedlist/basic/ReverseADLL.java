package doubly_linkedlist.basic;

public class ReverseADLL {
    public static Node reverseDLL(Node head) {
        if (head == null)
            return null;
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            head.prev = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
