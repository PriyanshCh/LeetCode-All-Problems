class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, StringBuilder cur, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(cur.toString());
            return;
        }

        if (parts == 4 || idx == s.length()) return;

        int len = cur.length();

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String part = s.substring(idx, idx + i);
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255)
                continue;

            if (parts > 0) cur.append('.');
            cur.append(part);

            backtrack(s, idx + i, parts + 1, cur, res);

            cur.setLength(len);
        }
    }
}
