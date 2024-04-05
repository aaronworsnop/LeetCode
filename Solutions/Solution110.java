class Solution110 {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (height(root) == -1) {
      return false;
    } else {
      return true;
    }
  }

  private int height(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    if (leftHeight == -1 || rightHeight == -1) {
      // Subtree imbalanced
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      // Imbalanced
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
