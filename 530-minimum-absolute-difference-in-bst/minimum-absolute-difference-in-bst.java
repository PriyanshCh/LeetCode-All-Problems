class Solution {
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (prev != null){
             min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }
}
