package singly_linkedlist.basic;

public class DeleteANode {
    public static Node deleteLast(Node list) {
        Node prev = list, temp = list.next;
        if (temp == null)
            return null;
        while (temp.next != null) {
            prev = prev.next;
            temp = temp.next;
        }
        prev.next = null;
        return list;
    }

    public void deleteNode(Node list) {
        Node temp = list, prev = list;
        while (temp.next != null) {
            prev = temp;
            temp.data = temp.next.data;
            temp = temp.next;
        }
        prev.next = null;
    }
}
