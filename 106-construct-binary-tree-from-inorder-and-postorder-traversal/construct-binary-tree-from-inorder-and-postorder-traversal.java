class Solution {
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        root.right = build(inorder, postorder, idx + 1, right);
        root.left = build(inorder, postorder, left, idx - 1);
        return root;
    }
}
