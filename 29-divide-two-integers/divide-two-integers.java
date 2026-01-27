class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean neg = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;

        while (a >= b) {
            long t = b;
            int m = 1;

            while (a >= (t << 1)) {
                t <<= 1;
                m <<= 1;
            }

            a -= t;
            ans += m;
        }

        return neg ? -ans : ans;
    }
}