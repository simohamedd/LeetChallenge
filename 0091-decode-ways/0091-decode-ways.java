class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base case: empty string has 1 way to decode
        dp[0] = 1;
        
        // Check first character
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= n; i++) {
            // Check single digit decoding
            char currentChar = s.charAt(i - 1);
            if (currentChar != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Check two digit decoding
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}