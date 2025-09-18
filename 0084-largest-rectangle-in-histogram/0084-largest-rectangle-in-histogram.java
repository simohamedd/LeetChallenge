class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            // Use a sentinel value at the end to force all remaining bars to be processed
            int h = (i == n) ? 0 : heights[i];
            
            // While current bar is lower than the bar at top of stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}