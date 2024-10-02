class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int sum = Arrays.stream(nums).sum();

        // If the total sum is less than the target or (sum + target) is odd, return 0.
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        
        int subsetSum = (sum + target) / 2;
        return countSubsets(nums, subsetSum);
        
    }
    public static int countSubsets(int[] nums,int sum){
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize dp for sum 0 (There is one way to get 0 sum, by taking no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];
                // Include the current element if it doesn't exceed the current sum
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}