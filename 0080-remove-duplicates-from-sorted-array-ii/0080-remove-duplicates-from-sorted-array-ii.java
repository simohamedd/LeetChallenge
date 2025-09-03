class Solution {
    public int removeDuplicates(int[] nums) {
        // If array has 2 or fewer elements, no duplicates need to be removed
        if (nums.length <= 2) {
            return nums.length;
        }
        

        int writeIndex = 2;
        
       
        for (int readIndex = 2; readIndex < nums.length; readIndex++) {

            if (nums[readIndex] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
}