package singly_linkedlist.hard;

class CNode {
    public int data;
    public CNode next;
    public CNode random;

    CNode() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    CNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    CNode(int data, CNode next, CNode random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

public class CloneALL {
    public static CNode cloneLL(CNode head) {
        //step 1: Make a nodes
        CNode iter = head;
        while (iter != null) {
            CNode t = new CNode(iter.data);
            t.next = iter.next;
            iter.next = t;
            iter = iter.next.next;
        }
        //step 2: Make the random pointers
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        CNode ans = new CNode(-1), temp = ans;
        iter = head;
        while (iter != null) {
            temp.next = iter.next;
            iter.next = iter.next.next;
            temp = temp.next;
            iter = iter.next;
        }
        return ans.next;
    }
}
