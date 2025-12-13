class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);

        int m = a.length, n = b.length;
        int l = 0, r = m;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int minRightA = i == m ? Integer.MAX_VALUE : a[i];

            int maxLeftB = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int minRightB = j == n ? Integer.MAX_VALUE : b[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) r = i - 1;
            else l = i + 1;
        }
        return 0.0;
    }
}
