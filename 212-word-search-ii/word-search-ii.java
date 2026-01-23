class Solution {
    class Node {
        Node[] n = new Node[26];
        String w;
    }

    int m, n;
    char[][] b;
    List<String> res = new ArrayList<>();
    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        Node r = new Node();
        for (String w : words) {
            Node c = r;
            for (char ch : w.toCharArray()) {
                int i = ch - 'a';
                if (c.n[i] == null) c.n[i] = new Node();
                c = c.n[i];
            }
            c.w = w;
        }

        b = board;
        m = b.length;
        n = b[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dfs(i, j, r);

        return res;
    }

    void dfs(int i, int j, Node c) {
        char ch = b[i][j];
        if (ch == '#' || c.n[ch - 'a'] == null) return;

        c = c.n[ch - 'a'];
        if (c.w != null) {
            res.add(c.w);
            c.w = null;
        }

        b[i][j] = '#';
        for (int[] x : d) {
            int ni = i + x[0], nj = j + x[1];
            if (ni >= 0 && nj >= 0 && ni < m && nj < n)
                dfs(ni, nj, c);
        }
        b[i][j] = ch;
    }
}
