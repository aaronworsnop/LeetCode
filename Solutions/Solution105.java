class Solution105 {
  private int pre = 0;
  private int in = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTreeBuilder(preorder, inorder, Integer.MAX_VALUE);
  }

  private TreeNode buildTreeBuilder(int[] preorder, int[] inorder, int stop) {
    if (pre >= preorder.length) return null;
    if (inorder[in] == stop) {
      in++;
      return null;
    }

    TreeNode node = new TreeNode(preorder[pre++]);
    node.left = buildTreeBuilder(preorder, inorder, node.val);
    node.right = buildTreeBuilder(preorder, inorder, stop);
    return node;
  }
}
