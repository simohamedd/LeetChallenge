class Solution {
    public int numTrees(int n) {
       
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // empty tree
        dp[1] = 1; // single node
        

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < i; j++) {
   
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }
}