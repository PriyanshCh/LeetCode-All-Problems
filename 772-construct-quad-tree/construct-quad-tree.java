class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] g, int x, int y, int size) {
        if (isSame(g, x, y, size))
            return new Node(g[x][y] == 1, true);
        int newSize = size / 2;
        return new Node(
            true,
            false,
            build(g, x, y, newSize),
            build(g, x, y + newSize, newSize),
            build(g, x + newSize, y, newSize),
            build(g, x + newSize, y + newSize, newSize)
        );
    }
    private boolean isSame(int[][] g, int x, int y, int size) {
        int val = g[x][y];
        for (int i = x; i < x + size; i++)
            for (int j = y; j < y + size; j++)
                if (g[i][j] != val) return false;
        return true;
    }
}
