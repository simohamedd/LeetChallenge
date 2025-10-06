class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n; // This is 2^n
        
        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}