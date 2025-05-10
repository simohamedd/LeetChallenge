class Solution {
    public int longestValidParentheses(String s) {
        // Stack to keep track of the indices of the characters
        Stack<Integer> stack = new Stack<>();
        // Initialize a variable to store the maximum length
        int maxLength = 0;
        // Add a base index for valid substring calculation
        stack.push(-1);
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // If we encounter '(', push the index onto the stack
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // If we encounter ')', pop the top index from the stack
                stack.pop();
                // Check if the stack is empty
                if (stack.isEmpty()) {
                    // If it is, push the current index as a base for the next valid substring
                    stack.push(i);
                } else {
                    // If not empty, calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
