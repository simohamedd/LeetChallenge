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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // If the fast pointer is null, it means we need to remove the head node
        if (fast == null) {
            return head.next;
        }
        
        // Move both slow and fast pointers until the fast pointer reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Remove the nth node from the end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
