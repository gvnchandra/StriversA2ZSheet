package stacks_queues;

import java.util.Stack;

public class QueueUsingStack {
    static class Queue {
        // Define the data members(if any) here.
        Stack<Integer> inp, out;

        Queue() {
            // Initialize your data structure here.
            inp = new Stack<>();
            out = new Stack<>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            inp.push(val);
        }

        int deQueue() {
            if (inp.isEmpty() && out.isEmpty())
                return -1;
            // Implement the dequeue() function.
            if (out.isEmpty()) {
                while (!inp.isEmpty()) {
                    out.add(inp.pop());
                }
            }
            return out.pop();
        }

        int peek() {
            // Implement the peek() function here.
            if (inp.isEmpty() && out.isEmpty())
                return -1;
            if (out.isEmpty()) {
                while (!inp.isEmpty()) {
                    out.add(inp.pop());
                }
            }
            return out.peek();
        }

        boolean isEmpty() {
            // Implement the isEmpty() function here.
            return inp.isEmpty() && out.isEmpty();
        }
    }
}
