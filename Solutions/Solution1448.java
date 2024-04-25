class Solution1448 {
  public int goodNodes(TreeNode root) {
    // Edge and known cases
    if (root == null) {
      return 0;
    }

    return BFS(root, Integer.MIN_VALUE);
  }

  private int BFS(TreeNode node, int maxOfPath) {
    if (node == null) {
      return 0;
    }

    if (node.val >= maxOfPath) {
      maxOfPath = node.val;
      return 1 + BFS(node.left, maxOfPath) + BFS(node.right, maxOfPath);
    } else {
      return BFS(node.left, maxOfPath) + BFS(node.right, maxOfPath);
    }
  }
}
