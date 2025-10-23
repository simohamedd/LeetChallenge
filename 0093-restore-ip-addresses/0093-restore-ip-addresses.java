class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // If string length is less than 4 or more than 12, impossible to form valid IP
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 segments
        if (current.size() == 4) {
            // Check if we've used all characters
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        
        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String segment = s.substring(start, start + len);
            
            // Check if this segment is valid
            if (isValidSegment(segment)) {
                current.add(segment);
                backtrack(s, start + len, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }
    
    private boolean isValidSegment(String segment) {
        // Check for leading zeros (except for "0" itself)
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        
        // Check if number is within range [0, 255]
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}