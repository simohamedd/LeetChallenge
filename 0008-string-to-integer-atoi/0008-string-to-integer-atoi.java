class Solution {
    public int myAtoi(String s) {
        // Step 1: Ignore leading whitespace
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // Step 2: Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        // Step 3: Read the integer and skip leading zeros
        long num = 0; // Use long to handle overflow before final conversion
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index) - '0');
            index++;

            // Step 4: Handle rounding for 32-bit signed integer range
            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) num * sign; // Apply the sign and return
    }
}
