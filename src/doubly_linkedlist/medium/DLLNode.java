package doubly_linkedlist.medium;

class DLLNode {
    public int data;
    public DLLNode next;
    public DLLNode prev;

    DLLNode() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DLLNode(int data, DLLNode next, DLLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}