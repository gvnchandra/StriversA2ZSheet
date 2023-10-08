package doubly_linkedlist.basic;


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
