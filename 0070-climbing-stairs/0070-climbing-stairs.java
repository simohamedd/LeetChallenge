class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int prev2 = 1; // ways to climb 1 step
        int prev1 = 2; // ways to climb 2 steps
        int current = 0;
        
        // Calculate from step 3 to n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}