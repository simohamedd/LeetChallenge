/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        // If both nodes are null, they are symmetric
        if (left == null && right == null) {
            return true;
        }
        
        // If only one is null, they are not symmetric
        if (left == null || right == null) {
            return false;
        }
        
        // Check if values are equal and subtrees are mirrors
        return (left.val == right.val) && 
               isMirror(left.left, right.right) && 
               isMirror(left.right, right.left);
    }
}