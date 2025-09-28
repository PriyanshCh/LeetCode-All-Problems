class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLive(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) board[i][j] = -1;
                if (board[i][j] == 0 && liveNeighbors == 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }

    private int countLive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                int r = i + x, c = j + y;
                if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) count++;
            }
        }
        return count;
    }
}
