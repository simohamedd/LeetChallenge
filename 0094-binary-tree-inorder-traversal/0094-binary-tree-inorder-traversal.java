import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // If the root is null, return an empty list immediately.
        if (root == null) {
            return result;
        }
        
        // Use a Stack to store nodes to visit.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // The loop continues as long as there are nodes to process (current is not null) 
        // OR there are nodes stored in the stack.
        while (current != null || !stack.isEmpty()) {
            // 1. Go to the leftmost node: push all left ancestors onto the stack.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // At this point, current is null, meaning we've reached the leftmost
            // point of the subtree rooted by the node at the top of the stack.

            // 2. Visit the node: Pop the top element (which is the next node in inorder).
            current = stack.pop();
            result.add(current.val);

            // 3. Move to the right subtree: The next node to process is the right child.
            // This starts the process over from step 1 for the right subtree.
            current = current.right;
        }

        return result;
    }
}