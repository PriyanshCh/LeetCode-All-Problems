/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }
    
        // Initialize two pointers, slow and fast,
        // to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
    
        // Traverse the linked list to find the
        // middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step at a time
            slow = slow.next;
    
            // Move fast pointer two steps at a time
            fast = fast.next.next;
        }
    
        // Reverse the second half of the 
        // linked list starting from the middle
        ListNode newHead = reverseLinkedList(slow.next);
    
        // Pointer to the first half
        ListNode first = head;
    
        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            // Compare data values of
            // nodes from both halves
    
            // If values do not match, the
            // list is not a palindrome
            if (first.val != second.val) {
                
                // Reverse the second half back
                // to its original state
                reverseLinkedList(newHead);
    
                // Not a palindrome
                return false;
            }
    
            // Move the first pointer
            first = first.next;
    
            // Move the second pointer
            second = second.next;
        }
    
        // Reverse the second half back
        // to its original state
        reverseLinkedList(newHead);
    
        // The linked list is a palindrome
        return true;
    }   

}