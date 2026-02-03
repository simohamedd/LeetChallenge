class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }
    
    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(node.val);
        
        if (node.left == null && node.right == null) {
            if (remainingSum == node.val) {
                result.add(new ArrayList<>(currentPath));
            }
        } else {
            if (node.left != null) {
                dfs(node.left, remainingSum - node.val, currentPath, result);
            }
            if (node.right != null) {
                dfs(node.right, remainingSum - node.val, currentPath, result);
            }
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
}