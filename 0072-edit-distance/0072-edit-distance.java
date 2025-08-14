class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        // If word1 is empty, we need to insert all characters of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // If word2 is empty, we need to delete all characters of word1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Characters don't match, take minimum of three operations
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j],     // delete from word1
                                 dp[i][j - 1]),    // insert into word1
                                 dp[i - 1][j - 1]  // replace in word1
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}