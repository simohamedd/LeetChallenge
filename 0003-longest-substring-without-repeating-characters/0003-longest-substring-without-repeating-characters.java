class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            charSet.add(s.charAt(right));
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1));  // Output: 3

        // Example 2
        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2)); 
    }
}