class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.equals("") || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(part);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.insert(0, "/" + stack.pop());
        return result.length() == 0 ? "/" : result.toString();
    }
}
