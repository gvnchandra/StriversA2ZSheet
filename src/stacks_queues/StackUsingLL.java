package stacks_queues;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
};

public class StackUsingLL {
    static class Stack {
        //Write your code here
        Node root, end;
        int count = 0;

        Stack() {
            //Write your code here
        }

        int getSize() {
            return count;
        }

        boolean isEmpty() {
            return count == 0;
        }

        void push(int data) {
            Node n = new Node(data);
            if (root == null)
                root = n;
            else
                end.next = n;
            end = n;
            count++;
        }

        void pop() {
            if (root != null) {
                if (count == 1) {
                    root = null;
                    end = null;
                } else {
                    Node temp = root;
                    while (temp.next != end)
                        temp = temp.next;
                    temp.next = null;
                }
            }
        }

        int getTop() {
            if (root == null)
                return -1;
            return end.data;
        }
    }
}
