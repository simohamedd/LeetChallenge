class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = merged.get(merged.size() - 1);
            int[] curr = intervals[i];

            // Step 2: Check if current interval overlaps with previous
            if (curr[0] <= prev[1]) {
                // Overlapping: merge them
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                // Non-overlapping: add to list
                merged.add(curr);
            }
        }

        // Convert List to 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}