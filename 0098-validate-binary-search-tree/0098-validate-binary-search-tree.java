class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // Base case: empty tree is valid
        if (node == null) {
            return true;
        }
        
        // Check if current node violates the min/max constraints
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        
        // Recursively validate left and right subtrees
        // Left subtree: all values must be < node.val
        // Right subtree: all values must be > node.val
        return isValidBST(node.left, min, node.val) && 
               isValidBST(node.right, node.val, max);
    }
}
