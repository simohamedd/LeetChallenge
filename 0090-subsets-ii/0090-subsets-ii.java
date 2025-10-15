class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        // Sort the array to group duplicates together
        Arrays.sort(nums);
        
        backtrack(nums, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result (make a copy since current will be modified)
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if current element is same as previous and 
            // previous wasn't included in current subset (i > start means we're not at the first element of this level)
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include current element
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            // Backtrack - remove current element
            current.remove(current.size() - 1);
        }
    }
}