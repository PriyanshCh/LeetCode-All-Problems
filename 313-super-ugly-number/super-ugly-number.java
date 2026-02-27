class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        long[] dp = new long[n];
        int[] idx = new int[k];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                next = Math.min(next, dp[idx[j]] * primes[j]);
            }
            dp[i] = next;
            for (int j = 0; j < k; j++) {
                if (dp[idx[j]] * primes[j] == next)
                    idx[j]++;
            }
        }
        return (int) dp[n - 1];
    }
}
