class Solution {
    // Approach 1: Mathematical Solution using Combinations
    // Time: O(min(m,n)), Space: O(1)
    public int uniquePaths(int m, int n) {
        // We need to calculate C(m+n-2, m-1) = C(m+n-2, n-1)
        // Choose the smaller value to minimize calculations
        int totalMoves = m + n - 2;
        int choose = Math.min(m - 1, n - 1);
        
        long result = 1;
        
        // Calculate C(totalMoves, choose) = totalMoves! / (choose! * (totalMoves-choose)!)
        // We can optimize this to avoid overflow by calculating iteratively
        for (int i = 0; i < choose; i++) {
            result = result * (totalMoves - i) / (i + 1);
        }
        
        return (int) result;
    }
    
    // Approach 2: Dynamic Programming Solution
    // Time: O(m*n), Space: O(m*n)
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row and first column
        // There's only one way to reach any cell in the first row (keep going right)
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // There's only one way to reach any cell in the first column (keep going down)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the rest of the grid
        // dp[i][j] = ways to reach cell from top + ways to reach cell from left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
    
    // Approach 3: Space-Optimized DP Solution
    // Time: O(m*n), Space: O(n)
    public int uniquePathsOptimized(int m, int n) {
        int[] dp = new int[n];
        
        // Initialize first row
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        // Process each row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j] represents paths from above (previous iteration)
                // dp[j-1] represents paths from left (current iteration)
                dp[j] = dp[j] + dp[j-1];
            }
        }
        
        return dp[n-1];
    }
}

