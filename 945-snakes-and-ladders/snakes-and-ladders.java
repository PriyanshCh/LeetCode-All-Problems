class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] visited = new boolean[target + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cell = q.poll();
                if (cell == target) return moves;

                for (int next = cell + 1; next <= Math.min(cell + 6, target); next++) {
                    int[] pos = getPos(next, n);
                    int val = board[pos[0]][pos[1]];
                    int dest = val == -1 ? next : val;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPos(int cell, int n) {
        int r = n - 1 - (cell - 1) / n;
        int c = (cell - 1) % n;
        if (((n - 1 - r) % 2) == 1) c = n - 1 - c;
        return new int[]{r, c};
    }
}
