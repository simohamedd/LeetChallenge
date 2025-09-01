class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        
        // Start backtracking from index 0
        backtrack(nums, 0, currentSubset, result);
        
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to result (including empty subset)
        result.add(new ArrayList<>(currentSubset));
        
        // Try adding each remaining element
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in current subset
            currentSubset.add(nums[i]);
            
            // Recursively generate subsets with nums[i] included
            // Start from i+1 to avoid duplicates and ensure unique subsets
            backtrack(nums, i + 1, currentSubset, result);
            
            // Backtrack: remove nums[i] to try other combinations
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}