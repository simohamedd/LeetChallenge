class Solution {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        
        current = head;
        return buildTree(0, count - 1);
    }
    
    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        
        TreeNode leftChild = buildTree(left, mid - 1);
        
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        
        TreeNode rightChild = buildTree(mid + 1, right);
        
        root.left = leftChild;
        root.right = rightChild;
        
        return root;
    }
}