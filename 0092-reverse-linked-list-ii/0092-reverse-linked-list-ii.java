class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: no reversal needed
        if (left == right) {
            return head;
        }
        
        // Create dummy node to handle case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Find the node just before position 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // 'current' is the first node to be reversed (at position 'left')
        ListNode current = prev.next;
        ListNode tail = current; // This will be the tail of the reversed section
        
        // Reverse the sublist from left to right
        ListNode prevReversed = null;
        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = prevReversed;
            prevReversed = current;
            current = next;
        }
        
        // Connect the reversed section back to the list
        prev.next = prevReversed; // Connect before section to new head of reversed section
        tail.next = current;      // Connect tail of reversed section to after section
        
        return dummy.next;
    }
}