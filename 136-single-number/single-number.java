class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                sum += (n >> i) & 1;
            }
            if (sum % 2 != 0)
                res |= (1 << i);
        }

        return res;
    }
}
