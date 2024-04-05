class Solution543 {
  private int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    max(root);
    return diameter;
  }

  private int max(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = max(node.left);
    int right = max(node.right);

    if ((left + right) > diameter) {
      diameter = left + right;
    }

    return Math.max(left, right) + 1;
  }
}
