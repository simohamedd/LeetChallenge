

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert string to char array, sort it, then back to string
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // Add original word to the list corresponding to its sorted version
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        // Return all the grouped anagrams as a list
        return new ArrayList<>(map.values());
    }
}