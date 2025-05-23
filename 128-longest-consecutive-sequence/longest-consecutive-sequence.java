class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            // only start if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int current = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    current += 1;
                }

                longest = Math.max(longest, current);
            }
        }

        return longest;
    }
}