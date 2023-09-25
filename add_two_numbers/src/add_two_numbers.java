public class add_two_numbers {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode tail = head;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int digit1 = (l1 != null) ? l1.val : 0;
        int digit2 = (l2 != null) ? l2.val : 0;
        l1 = (l1 != null) ? l1.next : null;
        l2 = (l2 != null) ? l2.next : null;
        int sum = digit1 + digit2 + carry;
        carry = sum / 10;
        int digit3 = sum % 10;
        tail.next = new ListNode(digit3);
        tail = tail.next;
    }
    return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);

        System.out.print("\n[");
        while (l3 != null) {
            System.out.print(l3.val);
            if (l3.next == null) System.out.println("] [7, 0, 8]\n");
            else System.out.print(", ");
            l3 = l3.next;
        }
    }
}