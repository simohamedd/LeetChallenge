class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String current = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char prevChar = current.charAt(0);

            for (int j = 1; j < current.length(); j++) {
                if (current.charAt(j) == prevChar) {
                    count++;
                } else {
                    next.append(count).append(prevChar);
                    prevChar = current.charAt(j);
                    count = 1;
                }
            }

            // Append the last counted sequence
            next.append(count).append(prevChar);

            // Update current for the next iteration
            current = next.toString();
        }

        return current;
    }
}