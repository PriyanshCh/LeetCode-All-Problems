class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int num : nums)
                ones += (num >> i) & 1;
            res += ones * (n - ones);
        }
        return res;
    }
}
