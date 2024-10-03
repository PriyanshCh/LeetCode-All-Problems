class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        // Fill the dp array with a default value (amount + 1) to represent infinity
        // (since you can't use more coins than the amount itself)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // Set to a value larger than any possible coin count
        }

        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Iterate through each coin
        for (int coin : coins) {
            // Update the dp array for all amounts that can be made using this coin
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still amount + 1, it means the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}