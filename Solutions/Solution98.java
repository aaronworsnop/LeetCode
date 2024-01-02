class Solution {
  public boolean isValidBST(TreeNode root) {
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helper(TreeNode node, long leftMin, long rightMax) {
    if (node == null) return true;

    if (node.val <= leftMin || node.val >= rightMax) return false;

    return helper(node.left, leftMin, node.val) && helper(node.right, node.val, rightMax);
  }
}
