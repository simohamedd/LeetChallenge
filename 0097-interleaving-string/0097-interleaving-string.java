class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // If lengths don't match, impossible
        if (m + n != s3.length()) {
            return false;
        }
        
        // dp[i][j] = true if first i chars of s1 and first j chars of s2
        // can form first i+j chars of s3
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty strings
        dp[0][0] = true;
        
        // Initialize first column (only using s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        
        // Initialize first row (only using s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1; // Current position in s3
                
                // Can we take from s1?
                boolean fromS1 = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(k);
                
                // Can we take from s2?
                boolean fromS2 = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(k);
                
                dp[i][j] = fromS1 || fromS2;
            }
        }
        
        return dp[m][n];
    }
}