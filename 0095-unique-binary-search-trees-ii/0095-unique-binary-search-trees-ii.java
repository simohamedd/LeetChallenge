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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(1, n);
    }
    
    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        // Base case: empty subtree
        if (start > end) {
            result.add(null);
            return result;
        }
        
        // Try each value as root
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees
            List<TreeNode> leftSubtrees = generateTreesHelper(start, i - 1);
            
            // Generate all possible right subtrees  
            List<TreeNode> rightSubtrees = generateTreesHelper(i + 1, end);
            
            // Combine each left subtree with each right subtree
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}