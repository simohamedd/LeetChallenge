class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        
        // Initialize the closest sum to a large value
        int closestSum = Integer.MAX_VALUE;
        
        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Pointer to the next element
            int right = nums.length - 1; // Pointer to the last element
            
            while (left < right) {
                // Calculate the current sum
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move the pointers based on the comparison of currentSum and target
                if (currentSum < target) {
                    left++; // Increase the sum
                } else if (currentSum > target) {
                    right--; // Decrease the sum
                } else {
                    // If currentSum is exactly the target, return it
                    return currentSum;
                }
            }
        }
        
        return closestSum; // Return the closest sum found
    }
}
