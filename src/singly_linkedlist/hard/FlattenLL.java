package singly_linkedlist.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

public class FlattenLL {

    static Node merge(Node a, Node b) {
        Node res = new Node(-1), temp = res;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
            temp.next = null;
        }
        if (a != null)
            temp.child = a;
        if (b != null)
            temp.child = b;
        return res.child;
    }

    public static Node flattenLinkedList1(Node head) {
        if (head == null || head.next == null)
            return head;
        head.next = flattenLinkedList1(head.next);
        return merge(head, head.next);
    }

    public static Node flattenLinkedList(Node head) {
        //By using priority queue
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        Node temp = head;
        while (temp != null) {
            pq.add(temp);
            temp = temp.next;
        }
        Node ans = null;
        while (!pq.isEmpty()) {
            Node t = pq.poll();
            if (ans == null) {
                ans = t;
                temp = ans;
            } else {
                temp.child = t;
                temp = temp.child;
            }
            if (t.child != null)
                pq.add(t.child);
        }
        return ans;
    }
}
