package doubly_linkedlist.medium;

public class DeleteAllOccurrencesOfAKeyInLL {
    public static DLLNode deleteAllOccurrences(DLLNode head, int k) {
        DLLNode curr = head, newHead = head;
        while (curr != null) {
            if (curr.data == k) {
                if (curr.prev == null && curr.next == null)
                    return null;
                if (curr.prev == null) {
                    newHead = curr.next;
                    curr.next.prev = null;
                } else if (curr.next == null) {
                    curr.prev.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return newHead;
    }
}
