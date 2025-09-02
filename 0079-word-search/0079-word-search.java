class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // Try starting from each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: if we've matched all characters
        if (index == word.length()) {
            return true;
        }
        
        // Check boundaries and if current cell matches the expected character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark the cell as visited by temporarily changing its value
        char temp = board[row][col];
        board[row][col] = '#'; // Using '#' as a marker for visited
        
        // Explore all 4 directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (dfs(board, word, newRow, newCol, index + 1)) {
                board[row][col] = temp; // Restore the cell before returning
                return true;
            }
        }
        
        // Backtrack: restore the original value
        board[row][col] = temp;
        return false;
    }
}