package doubly_linkedlist.medium;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
    }
}

public class FindAllPairsWithGivenSumInDLL {
    public static boolean findPair(Node<Integer> head, int k) {
        // Write your code here.
        Node<Integer> last = head;
        while (last.next != null) {
            last = last.next;
        }
        while (head != last && last.next != head) {
            if (head.data + last.data == k) {
                return true;
            } else if (head.data + last.data > k) {
                last = last.prev;
            } else
                head = head.next;
        }
        return false;
    }
}
