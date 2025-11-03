class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int required = need.size(), formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue())
                formed++;

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0])
                    ans = new int[]{right - left + 1, left, right};
                window.put(c, window.get(c) - 1);
                if (need.containsKey(c) && window.get(c) < need.get(c))
                    formed--;
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
