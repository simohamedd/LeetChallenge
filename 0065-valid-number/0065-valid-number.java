class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        
        int i = 0;
        int n = s.length();
        
        // Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        
        boolean hasDigit = false;
        
        // Check for digits before dot
        while (i < n && Character.isDigit(s.charAt(i))) {
            hasDigit = true;
            i++;
        }
        
        // Check for dot
        if (i < n && s.charAt(i) == '.') {
            i++;
            // Check for digits after dot
            while (i < n && Character.isDigit(s.charAt(i))) {
                hasDigit = true;
                i++;
            }
        }
        
        // Must have at least one digit so far (before or after dot)
        if (!hasDigit) {
            return false;
        }
        
        // Check for exponent
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            // Check for sign in exponent
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            
            // Must have at least one digit in exponent
            boolean hasExpDigit = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                hasExpDigit = true;
                i++;
            }
            
            if (!hasExpDigit) {
                return false;
            }
        }
        
        // Must have consumed all characters
        return i == n;
    }
}