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
    public ListNode reverseKGroup(ListNode head, int k) {
          ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Step 2: Create a dummy node to simplify the operations
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        // Step 3: Reverse nodes in groups of k
        while (count >= k) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode prev = null;
            ListNode curr = groupStart;
            
            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            // Connect the reversed group with the previous part and the next part
            prevGroupEnd.next = prev; // Connect the end of the previous group to the start of the reversed group
            groupStart.next = curr; // Connect the end of the reversed group to the next part
            
            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
            count -= k; // Decrease count by k
        }
        
        return dummy.next;
    }
}