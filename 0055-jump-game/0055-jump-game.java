class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond what we can reach
            if (i > maxReach) {
                return false;
            }
            // Update the farthest we can go
            maxReach = Math.max(maxReach, i + nums[i]);
            // Early exit if we can already reach the end
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true; // We can reach the end
    }
}