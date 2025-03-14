class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m;
        
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;

            // Adjust partitions
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1; // i is too small
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1; // i is too big
            } else {
                // Found the correct partition
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                
                if ((m + n) % 2 == 0) {
                    int minOfRight;
                    if (i == m) {
                        minOfRight = nums2[j];
                    } else if (j == n) {
                        minOfRight = nums1[i];
                    } else {
                        minOfRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxOfLeft + minOfRight) / 2.0;
                } else {
                    return maxOfLeft;
                }
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
