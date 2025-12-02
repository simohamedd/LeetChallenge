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
    private int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the index of each value in inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        // Base case: invalid range
        if (inStart > inEnd) {
            return null;
        }
        
        // Get the current root value from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the position of root in inorder array
        int rootIndex = inorderMap.get(rootVal);
        
        // Recursively build left and right subtrees
        // Left subtree: elements before rootIndex in inorder
        root.left = buildTreeHelper(preorder, inorder, inStart, rootIndex - 1, inorderMap);
        // Right subtree: elements after rootIndex in inorder
        root.right = buildTreeHelper(preorder, inorder, rootIndex + 1, inEnd, inorderMap);
        
        return root;
    }
}