class Solution {
    public int divide(int dividend, int divisor) {
          if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Return 2^31 - 1
        }
        
        // Determine the sign of the quotient
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Work with positive values for easier manipulation
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        long quotient = 0;
        
        // Perform the division using bit manipulation
        while (absDividend >= absDivisor) {
            long temp = absDivisor, multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1; // Double the divisor
                multiple <<= 1; // Double the multiple
            }
            absDividend -= temp; // Subtract the largest possible multiple of divisor
            quotient += multiple; // Add the multiples to the quotient
        }
        
        // Apply the sign to the quotient
        quotient = negative ? -quotient : quotient;
        
        // Return the final result within the 32-bit signed integer range
        return (int) quotient;
    }
}