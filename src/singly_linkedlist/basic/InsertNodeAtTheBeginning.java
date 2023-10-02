package singly_linkedlist.basic;

public class InsertNodeAtTheBeginning {
    public static Node insertAtFirst(Node list, int newValue) {
        Node n = new Node(newValue);
        n.next = list;
        return n;
    }
}
