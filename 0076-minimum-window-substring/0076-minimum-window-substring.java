class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        
        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int formed = 0; 

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);
            
            
            if (tCount.containsKey(rightChar) && 
                windowCount.get(rightChar).equals(tCount.get(rightChar))) {
                formed++;
            }
            
            
            while (left <= right && formed == tCount.size()) {
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                
                
                if (tCount.containsKey(leftChar) && 
                    windowCount.get(leftChar) < tCount.get(leftChar)) {
                    formed--;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}