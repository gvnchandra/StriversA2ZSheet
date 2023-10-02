package singly_linkedlist.basic;

public class SearchInALL {
    public static int searchInLinkedList(Node head, int k) {
        while (head != null) {
            if (head.data==k)
                return 1;
            head=head.next;
        }
        return 0;
    }
}
