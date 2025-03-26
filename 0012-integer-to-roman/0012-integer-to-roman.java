class Solution {
    public String intToRoman(int num) {
        // Define arrays for the Roman symbols and their corresponding values
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder(); // To build the Roman numeral string

        // Iterate over the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While num is greater than or equal to the value
            while (num >= values[i]) {
                result.append(symbols[i]); // Append the corresponding symbol
                num -= values[i]; // Subtract the value from num
            }
        }
        
        return result.toString(); // Return the final Roman numeral
    }
}
