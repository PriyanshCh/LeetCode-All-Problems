class NumArray {

    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        tree = new int[n + 1];

        for (int i = 0; i < n; i++)
            updateTree(i + 1, nums[i]);
    }

    private void updateTree(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += i & -i;
        }
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateTree(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}