class Solution {
    public String simplifyPath(String path) {
        // Split by '/' to get all components
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String component : components) {
            // Skip empty strings (from multiple slashes) and '.' (current directory)
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            // Go up one level (pop from stack) for '..'
            else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // For any other valid directory name, push to stack
            else {
                stack.push(component);
            }
        }
        
        // Reconstruct the simplified path
        StringBuilder result = new StringBuilder("/");
        
        // Append all directories in order
        for (String dir : stack) {
            result.append(dir).append("/");
        }
        
        // Remove trailing slash if not at root
        if (result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        
        return result.toString();
    }
}