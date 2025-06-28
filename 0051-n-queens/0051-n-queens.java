

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), result);
        return result;
    }

    private void backtrack(
        char[][] board,
        int row,
        Set<Integer> cols,
        Set<Integer> diag1,
        Set<Integer> diag2,
        List<List<String>> result
    ) {
        int n = board.length;
        
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            // Check if it's safe to place queen at (row, col)
            if (cols.contains(col)) continue;
            int d1 = row - col;  // For left diagonals
            int d2 = row + col;  // For right diagonals
            if (diag1.contains(d1) || diag2.contains(d2)) continue;

            // Place the queen
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            // Move to next row
            backtrack(board, row + 1, cols, diag1, diag2, result);

            // Backtrack
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }

    // Helper function to convert char[][] to List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}