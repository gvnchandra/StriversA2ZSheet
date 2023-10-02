package singly_linkedlist.medium;

public class CheckIfLLIsPalindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null)
            return false;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseLinkedList(slow.next);
        slow = head;
        while (fast != null) {
            if (slow.data != fast.data)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static Node reverseLinkedList(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
