class Solution {
    public String getPermutation(int n, int k) {
        // Create list of available numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Precompute factorials
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // Convert to 0-based indexing
        k--;
        
        StringBuilder result = new StringBuilder();
        
        // Build the kth permutation
        for (int i = n - 1; i >= 0; i--) {
            // Determine which number should be at current position
            int index = k / factorial[i];
            
            // Add the selected number to result
            result.append(numbers.get(index));
            
            // Remove the selected number from available numbers
            numbers.remove(index);
            
            // Update k for next iteration
            k %= factorial[i];
        }
        
        return result.toString();
    }
}