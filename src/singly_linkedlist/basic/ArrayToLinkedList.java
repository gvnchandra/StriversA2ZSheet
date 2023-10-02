package singly_linkedlist.basic;

public class ArrayToLinkedList {
    public static Node constructLL(int[] arr) {
        Node head = null, temp = null;
        for (int i = 0; i < arr.length; i++) {
            Node t = new Node(arr[i]);
            if (i == 0) {
                head = t;
                temp = head;
            } else {
                temp.next = t;
                temp = temp.next;
            }
        }
        return head;
    }
}
