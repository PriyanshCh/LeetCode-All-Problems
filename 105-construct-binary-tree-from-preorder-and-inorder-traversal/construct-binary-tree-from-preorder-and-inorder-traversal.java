class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);
        return root;
    }
}
