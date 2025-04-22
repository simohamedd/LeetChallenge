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
    public ListNode swapPairs(ListNode head) {
          ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy; // Points to the node before the pair being swapped
        
        while (prev.next != null && prev.next.next != null) {
            // Identify the two nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Perform the swap
            first.next = second.next; // Link first to the node after second
            second.next = first;       // Link second to first
            prev.next = second;        // Link prev to the new first (which is second)
            
            // Move prev two nodes ahead for the next swap
            prev = first;
        }
        
        return dummy.next; 
    }
}