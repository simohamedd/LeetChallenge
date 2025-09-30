class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create dummy heads for both partitions
        ListNode lessHead = new ListNode(0);
        ListNode greaterEqualHead = new ListNode(0);
        
        // Pointers to track the current end of each partition
        ListNode less = lessHead;
        ListNode greaterEqual = greaterEqualHead;
        
        // Iterate through the original list
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greaterEqual.next = current;
                greaterEqual = greaterEqual.next;
            }
            current = current.next;
        }
        
        // Connect the two partitions
        less.next = greaterEqualHead.next;
        
        // Terminate the final list
        greaterEqual.next = null;
        
        return lessHead.next;
    }
}