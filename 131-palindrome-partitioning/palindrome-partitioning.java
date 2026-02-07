class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(String s, int idx, List<String> cur, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                cur.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
