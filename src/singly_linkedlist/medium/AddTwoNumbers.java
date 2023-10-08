package singly_linkedlist.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(3);

        Node head2 = new Node(8);
        head2.next = new Node(4);
        head2.next.next = new Node(2);
        System.out.println(addTwoNumbers(head1, head2));
    }

    static Node addTwoNumbers(Node head1, Node head2) {
        int carry = 0;
        Node ans = new Node(-1), temp = ans;
        while (head1 != null || head2 != null || carry==1) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return ans.next;
    }
}
