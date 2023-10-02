package doubly_linkedlist.basic;

public class InsertAtEndInDLL {
    public static Node insertAtTail(Node list, int K) {
        if (list == null)
            return new Node(K, null, null);
        while (list.next != null) {
            list = list.next;
        }
        list.next = new Node(K, null, list);
        while (list.prev != null) {
            list = list.prev;
        }
        return list;
    }
}
