class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] a, int target, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < a.length; i++) {
            if (i > idx && a[i] == a[i - 1]) continue;
            if (a[i] > target) break;

            cur.add(a[i]);
            backtrack(a, target - a[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
