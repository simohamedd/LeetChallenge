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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        ListNode current = head;
        while (current != null) {
            // Check if current is start of duplicates
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Skip the entire sequence of duplicates
                prev.next = current.next;
            } else {
                // No duplicate, move prev forward
                prev = prev.next;
            }
            current = current.next;
        }
        
        return dummy.next;
    }
}