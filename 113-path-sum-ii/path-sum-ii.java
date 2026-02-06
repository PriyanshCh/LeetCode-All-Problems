class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    void helper(TreeNode n, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (n == null) return;

        cur.add(n.val);
        sum -= n.val;

        if (n.left == null && n.right == null && sum == 0)
            res.add(new ArrayList<>(cur));

        helper(n.left, sum, cur, res);
        helper(n.right, sum, cur, res);

        cur.remove(cur.size() - 1);
    }
}
