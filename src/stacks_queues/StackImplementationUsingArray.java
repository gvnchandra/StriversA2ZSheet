package stacks_queues;

public class StackImplementationUsingArray {
    static class Stack {
        int[] st;
        int top;

        Stack(int capacity) {
            st = new int[capacity];
            top = -1;
        }

        public void push(int num) {
            if (top == st.length - 1)
                return;
            st[++top] = num;
        }

        public int pop() {
            if (top != -1)
                return st[top--];
            return -1;
        }

        public int top() {
            if (top != -1)
                return st[top];
            return -1;
        }

        public int isEmpty() {
            return top == -1 ? 1 : 0;
        }

        public int isFull() {
            return top == st.length - 1 ? 1 : 0;
        }
    }
}
