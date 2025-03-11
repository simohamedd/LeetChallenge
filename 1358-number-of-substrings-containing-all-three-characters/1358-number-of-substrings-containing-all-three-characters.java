class Solution {
    public int numberOfSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int n = s.length();
        int count = 0;
        
        // Initialize last positions to -1
        int lastA = -1, lastB = -1, lastC = -1;
        
        for (int i = 0; i < n; i++) {
            // Update last position of current character
            if (s.charAt(i) == 'a') lastA = i;
            else if (s.charAt(i) == 'b') lastB = i;
            else if (s.charAt(i) == 'c') lastC = i;
            
            // If we have all three characters
            if (lastA != -1 && lastB != -1 && lastC != -1) {
                // Find leftmost character position
                int leftmost = Math.min(Math.min(lastA, lastB), lastC);
                
                // Add count of valid substrings
                // Any substring starting from index 0 to leftmost and ending at current index i
                // will have all three characters
                count += leftmost + 1;
            }
        }
        
        return count;
    }
}