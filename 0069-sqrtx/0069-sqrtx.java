class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = 1;
        int right = x / 2 + 1; // sqrt(x) <= x/2 for x >= 4, +1 to handle edge cases
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid*mid <= x
            // Use long to avoid integer overflow
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid; // This is a valid candidate, but we might find a larger one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}