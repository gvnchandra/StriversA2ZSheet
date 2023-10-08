package singly_linkedlist.hard;

class LLNode {
    public int data;
    public LLNode next;

    LLNode() {
        this.data = 0;
        this.next = null;
    }

    LLNode(int data) {
        this.data = data;
        this.next = null;
    }

    LLNode(int data, LLNode next) {
        this.data = data;
        this.next = next;
    }
}
