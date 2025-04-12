import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string is of the maximum length, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // If we can add an open parenthesis, add it and recurse
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // If we can add a close parenthesis, add it and recurse
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> combinations = solution.generateParenthesis(n);
        System.out.println(combinations); // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
