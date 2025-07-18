class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (num <= n * n) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;

            // Traverse from right to left
            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = num++;
            }
            bottom--;

            // Traverse from bottom to top
            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}