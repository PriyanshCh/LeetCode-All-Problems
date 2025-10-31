class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) length++;

        ListNode dummy = new ListNode(0, head);
        for (int size = 1; size < length; size <<= 1) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);
                prev.next = merge(left, right);
                while (prev.next != null) prev = prev.next;
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int n) {
        while (n-- > 1 && head != null) head = head.next;
        if (head == null) return null;
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1; l1 = l1.next;
            } else {
                p.next = l2; l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
