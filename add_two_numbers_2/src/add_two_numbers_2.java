public class add_two_numbers_2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode ptr = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = ptr;
            ptr = head;
            head = node;
        }
        return ptr;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;
        while (l1 != null && l2 != null && carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return reverseLinkedList(head.next);
    }

    public static void printList(ListNode head) {
        ListNode ptr = new ListNode(head.val, head.next);
        System.out.println();
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        printList(l1);
        printList(reverseLinkedList(l1));

    }
}