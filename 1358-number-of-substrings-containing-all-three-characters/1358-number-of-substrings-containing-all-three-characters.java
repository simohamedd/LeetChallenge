class Solution {
    public int numberOfSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int n = s.length();
        int count = 0;
        
        
        int lastA = -1, lastB = -1, lastC = -1;
        
        for (int i = 0; i < n; i++) {
            
            if (s.charAt(i) == 'a') lastA = i;
            else if (s.charAt(i) == 'b') lastB = i;
            else if (s.charAt(i) == 'c') lastC = i;
            
            
            if (lastA != -1 && lastB != -1 && lastC != -1) {
                
                int leftmost = Math.min(Math.min(lastA, lastB), lastC);
                
                
                count += leftmost + 1;
            }
        }
        
        return count;
    }
}