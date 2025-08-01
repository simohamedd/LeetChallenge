class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // Add 1 to current digit (either the initial +1 or from carry)
            digits[i]++;
            
            // If no carry, we're done
            if (digits[i] < 10) {
                return digits;
            }
            
            // If digit is 10, set to 0 and carry 1 to next digit
            digits[i] = 0;
        }
        
        // If we're here, it means we have a carry after all digits
        // (e.g., 999 + 1 = 1000)
        int[] result = new int[n + 1];
        result[0] = 1; // The carry becomes the new most significant digit
        return result;
    }
}