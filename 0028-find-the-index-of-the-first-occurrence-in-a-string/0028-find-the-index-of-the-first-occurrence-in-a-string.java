class Solution {
    public int strStr(String haystack, String needle) {
         if (needle.isEmpty()) {
            return 0;
        }
        
        // Use indexOf to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }
}