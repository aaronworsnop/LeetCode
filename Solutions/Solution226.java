class Solution226 {
  public TreeNode invertTree(TreeNode root) {
    // BFS swapping each thing
    invertBfs(root);
    return root;
  }

  private void invertBfs(TreeNode node) {
    if (node == null) {
      return;
    } else if (node.left == null && node.right == null) {
      return;
    }

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    invertBfs(node.left);
    invertBfs(node.right);
  }
}
