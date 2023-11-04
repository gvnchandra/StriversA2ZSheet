package stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingArray {
    static class Stack {
        Queue<Integer> q;

        public Stack() {
            q = new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            return q.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return q.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            q.add(element);
            int n = q.size();
            for (int i = 1; i < n; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            // Implement the pop() function.
            if (q.isEmpty())
                return -1;
            return q.poll();
        }

        public int top() {
            // Implement the top() function.
            if (q.isEmpty())
                return -1;
            return q.peek();
        }
    }
}
