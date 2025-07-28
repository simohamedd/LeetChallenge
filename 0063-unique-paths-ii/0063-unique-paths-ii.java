class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If start or end has an obstacle, no path is possible
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        
        // Create DP table
        int[][] dp = new int[m][n];
        
        // Initialize starting position
        dp[0][0] = 1;
        
        // Fill the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1];
            }
            // If there's an obstacle, dp[0][j] remains 0
        }
        
        // Fill the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0];
            }
            // If there's an obstacle, dp[i][0] remains 0
        }
        
        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                // If obstacleGrid[i][j] == 1, dp[i][j] remains 0
            }
        }
        
        return dp[m-1][n-1];
    }
}