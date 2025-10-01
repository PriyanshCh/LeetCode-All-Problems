class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mS = new int[256];
        int[] mT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            if (mS[c1] != mT[c2]) return false;

            mS[c1] = i + 1;
            mT[c2] = i + 1;
        }
        return true;
    }
}
