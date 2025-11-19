class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];

        for (int n : nums) {
            currMax = Math.max(n, currMax + n);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(n, currMin + n);
            minSum = Math.min(minSum, currMin);

            total += n;
        }

        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
