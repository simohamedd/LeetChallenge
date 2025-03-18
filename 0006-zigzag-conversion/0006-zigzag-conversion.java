class Solution {
    public String convert(String s, int numRows) {
          if (numRows <= 1 || numRows >= s.length()) {
            return s; // No zigzag needed
        }

        // Create an array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0; // Start at the first row
        boolean goingDown = false; // Direction flag

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c); // Add character to the current row

            // Change direction if we are at the top or bottom row
            if (currentRow == 0) {
                goingDown = true; // Start going down
            } else if (currentRow == numRows - 1) {
                goingDown = false; // Start going up
            }

            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Build the final result by concatenating all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}