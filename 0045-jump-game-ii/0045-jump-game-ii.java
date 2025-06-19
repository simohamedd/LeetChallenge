class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest index we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the range for the current jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Early exit if we've already reached or passed the last index
                if (currentEnd >= n - 1) break;
            }
        }

        return jumps;
    }
}