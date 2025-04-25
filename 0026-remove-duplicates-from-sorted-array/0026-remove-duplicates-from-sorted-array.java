class Solution {
    public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
            return 0;
        }
        
        int k = 1; // Start with the first unique element
        
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the last unique element
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Place it in the next position of unique elements
                k++; // Increment the count of unique elements
            }
        }
        
        return k; // Return the number of unique elements
    }
}