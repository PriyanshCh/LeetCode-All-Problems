class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        qp.add(p);
        qq.add(q);

        while (!qp.isEmpty() && !qq.isEmpty()) {
            TreeNode n1 = qp.poll();
            TreeNode n2 = qq.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;

            qp.add(n1.left);
            qp.add(n1.right);
            qq.add(n2.left);
            qq.add(n2.right);
        }
        return true;
    }
}
