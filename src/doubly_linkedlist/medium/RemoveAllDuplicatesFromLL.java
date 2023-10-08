package doubly_linkedlist.medium;

public class RemoveAllDuplicatesFromLL {
    public static Node uniqueSortedList(Node head) {
        //1->2->2->2->3
        Node temp = head.next, prev = head;
        while (temp != null) {
            while (prev.data == temp.data) {
                temp = temp.next;
                prev.next = temp;
                if (temp != null)
                    temp.prev = prev;
                else
                    return head;
            }
            prev = prev.next;
            temp = temp.next;
        }
        return head;
    }
}
