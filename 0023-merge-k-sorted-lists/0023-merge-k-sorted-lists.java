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
    public ListNode mergeKLists(ListNode[] lists) {
           PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each linked list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        // Create a dummy node to help with the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // While there are nodes in the min-heap
        while (!minHeap.isEmpty()) {
            // Get the smallest node
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode; // Add it to the merged list
            current = current.next; // Move the pointer forward
            
            // If there is a next node in the list, add it to the min-heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}