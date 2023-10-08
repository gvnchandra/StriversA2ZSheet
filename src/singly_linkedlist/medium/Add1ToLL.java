package singly_linkedlist.medium;

public class Add1ToLL {
    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(9);
        Node temp = addNode(head1);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node addNode(Node head) {
        f(head);
        Node start = head;
        if (head.data / 10 == 1) {
            start = new Node(1);
            start.next = head;
        }
        Node temp = start;
        while (temp != null) {
            temp.data = temp.data % 10;
            temp = temp.next;
        }
        return start;
    }

    static void f(Node head) {
        if (head.next == null) {
            head.data = head.data + 1;
            return;
        }
        f(head.next);
        head.data = head.data + head.next.data / 10;
    }
}
