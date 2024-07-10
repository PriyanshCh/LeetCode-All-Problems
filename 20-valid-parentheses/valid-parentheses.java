class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')','(');
        Hmap.put('}','{');
        Hmap.put(']','[');
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int index = 0; index < s.length(); index++){
           
            if (s.charAt(index) == '(' || s.charAt(index) == '{'||s.charAt(index) == '[')
            {       
                stack.push(s.charAt(index));
                continue;
            }
           
            if (stack.size() == 0 || Hmap.get(s.charAt(index)) != stack.pop()) {
                return false;
            }
        }
        
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}