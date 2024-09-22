class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        //Total SUm
        for(int num:nums){
            totalSum += num;
        }
        //if sum is odd return false
        if(totalSum % 2 != 0){
            return false;
        }
        //else return true
        int target=totalSum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;

        for(int num:nums){
            for(int j=target; j>=num; j--){
                dp[j]=dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }
}