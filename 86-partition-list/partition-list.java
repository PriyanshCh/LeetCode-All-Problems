class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode befHead = new ListNode(0);
        ListNode aftHead = new ListNode(0);
        
        ListNode before = befHead, after = aftHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = aftHead.next;
        
        return befHead.next;
    }
}
