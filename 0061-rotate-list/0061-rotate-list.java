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
    public ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Find the length of the list and the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Calculate effective rotations needed
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
        
        // Make the list circular
        tail.next = head;
        
        // Find the new tail (length - k - 1 steps from head)
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // New head is the node after new tail
        ListNode newHead = newTail.next;
        
        // Break the circular connection
        newTail.next = null;
        
        return newHead;
    }
}