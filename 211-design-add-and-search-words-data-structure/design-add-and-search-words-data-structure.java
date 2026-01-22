class WordDictionary {
    class Node {
        Node[] n = new Node[26];
        boolean e;
    }

    Node r = new Node();

    public void addWord(String w) {
        Node c = r;
        for (char ch : w.toCharArray()) {
            int i = ch - 'a';
            if (c.n[i] == null) c.n[i] = new Node();
            c = c.n[i];
        }
        c.e = true;
    }

    public boolean search(String w) {
        return f(w, 0, r);
    }

    boolean f(String w, int i, Node c) {
        if (c == null) return false;
        if (i == w.length()) return c.e;

        char ch = w.charAt(i);
        if (ch == '.') {
            for (Node x : c.n)
                if (f(w, i + 1, x)) return true;
            return false;
        }
        return f(w, i + 1, c.n[ch - 'a']);
    }
}
