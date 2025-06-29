class Solution {
    private int count = 0;
    private boolean[] cols;      // To track occupied columns
    private boolean[] diag1;     // To track occupied main diagonals (row - col)
    private boolean[] diag2;     // To track occupied anti-diagonals (row + col)

    public int totalNQueens(int n) {
        cols = new boolean[n];
        // The range for row - col is -(n-1) to (n-1). Shifting by (n-1) makes it 0 to 2*(n-1).
        diag1 = new boolean[2 * n - 1]; 
        // The range for row + col is 0 to 2*(n-1).
        diag2 = new boolean[2 * n - 1];

        solveNQueens(0, n); // Start placing queens from row 0
        return count;
    }

    private void solveNQueens(int row, int n) {
        // Base case: All queens have been placed
        if (row == n) {
            count++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // Check if the current position (row, col) is safe
            // col[col] checks if the column is free
            // diag1[row - col + n - 1] checks if the main diagonal is free
            // diag2[row + col] checks if the anti-diagonal is free
            if (!cols[col] && !diag1[row - col + n - 1] && !diag2[row + col]) {
                // Place the queen
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                // Recurse for the next row
                solveNQueens(row + 1, n);

                // Backtrack: Remove the queen to explore other possibilities
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
    }
}