import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to allow early stopping
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target) {
                // No need to continue since candidates are sorted
                break;
            }
            
            path.add(candidate); // Choose the candidate
            // Not incrementing i because we can reuse same element
            backtrack(candidates, target - candidate, i, path, result);
            path.remove(path.size() - 1); // Un-choose the candidate (backtrack)
        }
    }
}