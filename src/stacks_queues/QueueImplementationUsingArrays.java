package stacks_queues;

public class QueueImplementationUsingArrays {
    class Queue {
        int front, rear;
        int[] arr;
        int n, count = 0;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
            n = arr.length;
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if (count == n)
                return;
            arr[rear % n] = e;
            rear++;
            count++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if (count == 0)
                return -1;
            int ele = arr[front % n];
            front++;
            count--;
            return ele;
        }
    }
}
