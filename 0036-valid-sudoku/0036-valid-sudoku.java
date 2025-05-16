class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // Check row, column and 3x3 box
                    if (!isValidRow(board, i, j) ||
                        !isValidColumn(board, i, j) ||
                        !isValidBox(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row, int col) {
        for (int k = 0; k < 9; k++) {
            if (k != col && board[row][k] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int row, int col) {
        for (int k = 0; k < 9; k++) {
            if (k != row && board[k][col] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int currentRow = startRow + i;
                int currentCol = startCol + j;
                if ((currentRow != row || currentCol != col) &&
                    board[currentRow][currentCol] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}