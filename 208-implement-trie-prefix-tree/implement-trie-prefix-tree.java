class Trie {

    class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) return false;
            cur = cur.next[i];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) return false;
            cur = cur.next[i];
        }
        return true;
    }
}
