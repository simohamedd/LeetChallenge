class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try each number from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            // Skip if we don't have enough remaining numbers to reach k
            if (current.size() + (n - i + 1) < k) {
                continue;
            }
            
            // Choose
            current.add(i);
            
            // Explore
            backtrack(result, current, i + 1, n, k);
            
            // Unchoose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}