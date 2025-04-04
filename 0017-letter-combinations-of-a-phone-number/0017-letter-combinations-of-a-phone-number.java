import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        // Mapping of digits to letters
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(result, new StringBuilder(), digits, 0, digitToLetters);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String digits, int index, Map<Character, String> digitToLetters) {
        // If the path length is equal to the length of digits, we have a complete combination
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char currentDigit = digits.charAt(index);
        String letters = digitToLetters.get(currentDigit);

        for (char letter : letters.toCharArray()) {
            // Add the letter to the path and move to the next digit
            path.append(letter);
            backtrack(result, path, digits, index + 1, digitToLetters);
            // Remove the letter before the next iteration (backtrack)
            path.deleteCharAt(path.length() - 1);
        }
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23")); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations(""));    // Output: []
        System.out.println(solution.letterCombinations("2"));   // Output: ["a","b","c"]
    }
}
