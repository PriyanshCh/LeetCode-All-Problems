class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }

        ListNode prev = null, next = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
