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
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }
    
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }

    // Method to deserialize a string representation of a linked list
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        // Remove brackets and split by comma
        if (data.startsWith("[") && data.endsWith("]")) {
            data = data.substring(1, data.length() - 1);
        }
        
        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String value : values) {
            value = value.trim(); // Trim whitespace
            if (!value.equals("null") && !value.isEmpty()) {
                current.next = new ListNode(Integer.parseInt(value));
                current = current.next;
            }
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse both lists and append the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // If there are remaining nodes in either list, append them
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        
        // Return the merged list, which starts from the next of the dummy node
        return dummy.next;
    }
}

public class Driver {
    public static void main(String[] args) {
        // Example input strings
        String list1Str = "[1,2,4]";
        String list2Str = "[1,3,4]";
        
        // Deserialize the input strings to create linked lists
        ListNode list1 = ListNode.deserialize(list1Str);
        ListNode list2 = ListNode.deserialize(list2Str);
        
        // Merge the two lists
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        
        // Print the merged list
        printLinkedList(mergedList); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }
    
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
