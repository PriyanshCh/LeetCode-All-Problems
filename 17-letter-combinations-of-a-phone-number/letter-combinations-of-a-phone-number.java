import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",    "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for (char d : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String s : res)
                for (char c : map[d - '0'].toCharArray())
                    temp.add(s + c);
            res = temp;
        }
        return res;
    }
}
