class Solution {
  private int maxPath;

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    this.maxPath = root.val;

    maxPathDFS(root);
    return maxPath;
  }

  private int maxPathDFS(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftMax = Math.max(0, maxPathDFS(node.left));
    int rightMax = Math.max(0, maxPathDFS(node.right));

    maxPath = Math.max(maxPath, leftMax + rightMax + node.val);
    return Math.max(leftMax, rightMax) + node.val;
  }
}
