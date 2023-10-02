package doubly_linkedlist.basic;

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class ArrayToLinkedList {
    public static Node constructDLL(int[] arr) {
        Node start = new Node(arr[0], null, null);
        Node temp = start;
        for (int i = 1; i < arr.length; i++) {
            Node t = new Node(arr[i], null, temp);
            temp.next = t;
            temp = t;
        }
        return start;
    }
}
