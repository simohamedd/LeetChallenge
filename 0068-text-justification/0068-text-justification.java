class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            // Find how many words can fit in current line
            int lineStart = i;
            int lineLength = words[i].length();
            
            i++;
            while (i < words.length && lineLength + 1 + words[i].length() <= maxWidth) {
                lineLength += 1 + words[i].length();
                i++;
            }
            
            // Now format the line
            int numWords = i - lineStart;
            
            // Last line - left justify
            if (i == words.length) {
                StringBuilder line = new StringBuilder();
                for (int j = lineStart; j < i; j++) {
                    if (j > lineStart) {
                        line.append(" ");
                    }
                    line.append(words[j]);
                }
                // Add padding at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
                result.add(line.toString());
            }
            // Single word line - left justify
            else if (numWords == 1) {
                StringBuilder line = new StringBuilder(words[lineStart]);
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
                result.add(line.toString());
            }
            // Multiple words - full justify
            else {
                // Calculate total spaces needed
                int totalSpaces = maxWidth;
                for (int j = lineStart; j < i; j++) {
                    totalSpaces -= words[j].length();
                }
                
                // Distribute spaces between words
                int spacesBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                
                StringBuilder line = new StringBuilder();
                line.append(words[lineStart]);
                
                for (int j = lineStart + 1; j < i; j++) {
                    // Add base spaces
                    for (int k = 0; k < spacesBetweenWords; k++) {
                        line.append(" ");
                    }
                    // Add extra space if needed (left slots get priority)
                    if (j - lineStart <= extraSpaces) {
                        line.append(" ");
                    }
                    line.append(words[j]);
                }
                
                result.add(line.toString());
            }
        }
        
        return result;
    }
}