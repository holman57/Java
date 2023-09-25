public class reverse_nodes_in_k_group {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    Given the head of a linked list, reverse the nodes of the list k at a time,
//    and return the modified list.

//    k is a positive integer and is less than or equal to the length of the linked list.
//    If the number of nodes is not a multiple of k then left-out nodes, in the end,
//    should remain as it is.

//    You may not alter the values in the list's nodes, only nodes themselves may be changed.
    public static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode sub_head = null;

        System.out.println();
        System.out.print("head: ");
        printList(head);
        while (k > 0) {
            ListNode node = head.next;
            head.next = sub_head;
            sub_head = head;
            head = node;
            k--;

            System.out.println();
            System.out.print("sub_head: ");
            printList(sub_head);
            System.out.println();
            System.out.print("head: ");
            printList(head);
        }
        return sub_head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode tail = null;
        ListNode out_head = null;
        while (ptr != null) {
            int n = 0;
            ptr = head;
            while (n < k && ptr != null) {
                ptr = ptr.next;
                n += 1;
            }
            if (n == k) {
                ListNode reverse_head = reverseLinkedList(head, k);
                if (out_head == null) out_head = reverse_head;
                if (tail != null) tail.next = reverse_head;
                tail = head;
                head = ptr;
            }
        }
        if (tail != null) tail.next = head;
        return out_head == null ? head : out_head;
    }

    public static String test(ListNode in, ListNode out) {
        if (in == null || out == null) return "Fail";
        while (in != null && out != null) {
            if (in.val == (out.val)) {
                in = in.next;
                out = out.next;
            } else {
                return "Fail";
            }
        }
        return "Pass";
    }

    public static void printList(ListNode head) {
        ListNode ptr = new ListNode(head.val, head.next);
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }
        public static void main(String[] args) {
//          Input: head = [1,2,3,4,5], k = 2
//          Output: [2,1,4,3,5]
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(3);
            l1.next.next.next = new ListNode(4);
            l1.next.next.next.next = new ListNode(5);
            ListNode out1 = new ListNode(2);
            out1.next = new ListNode(1);
            out1.next.next = new ListNode(4);
            out1.next.next.next = new ListNode(3);
            out1.next.next.next.next = new ListNode(5);
            int k1 = 2;
            System.out.println(test(reverseKGroup(l1, k1), out1));

//          Input: head = [1,2,3,4,5], k = 3
//          Output: [3,2,1,4,5]
            ListNode l2 = new ListNode(1);
            l2.next = new ListNode(2);
            l2.next.next = new ListNode(3);
            l2.next.next.next = new ListNode(4);
            l2.next.next.next.next = new ListNode(5);
            ListNode out2 = new ListNode(3);
            out2.next = new ListNode(2);
            out2.next.next = new ListNode(1);
            out2.next.next.next = new ListNode(4);
            out2.next.next.next.next = new ListNode(5);
            int k2 = 3;
            System.out.println(test(reverseKGroup(l2, k2), out2));
    }
}
