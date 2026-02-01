class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1, x = 1;

        while (l <= r) {
            for (int i = l; i <= r; i++) a[t][i] = x++;
            for (int i = t + 1; i <= b; i++) a[i][r] = x++;
            for (int i = r - 1; i >= l; i--) a[b][i] = x++;
            for (int i = b - 1; i > t; i--) a[i][l] = x++;

            l++; r--; t++; b--;
        }

        return a;
    }
}
