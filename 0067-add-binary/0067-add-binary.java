class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Process digits from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            // Add digit from string a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            // Add digit from string b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // Current digit is sum % 2
            result.append(sum % 2);
            
            // Carry for next position is sum / 2
            carry = sum / 2;
        }
        
        // Since we built the result from right to left, reverse it
        return result.reverse().toString();
    }
}