class Solution {
    public boolean isPalindrome(int x) {
        // Check if the number is negative
        if (x < 0) return false;

        // Convert the integer to a string
        String str = String.valueOf(x);
        int i = 0; // Start from the beginning
        int j = str.length() - 1; // Start from the end

        // Compare characters from both ends
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false; // If characters don't match 9 here where i got first fault 
            i++;
            j--;
        }
        return true; // If all characters matched
    }
}
