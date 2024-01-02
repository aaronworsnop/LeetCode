/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
    return helper(root.left, root.val, Long.MIN_VALUE, true)
        && helper(root.right, root.val, Long.MAX_VALUE, false);
  }

  private boolean helper(TreeNode node, int parentVal, long grandparentVal, boolean isLeftChild) {
    if (node == null) return true;

    if (node.left == null && node.right == null) {
      return isLeftChild && node.val < parentVal && node.val > grandparentVal
          || !isLeftChild && node.val > parentVal && node.val < grandparentVal;
    } else {
      long leftGrand = grandparentVal;
      long rightGrand = grandparentVal;

      if (isLeftChild) rightGrand = parentVal;
      else leftGrand = parentVal;

      return (isLeftChild && node.val < parentVal && node.val > grandparentVal
              || !isLeftChild && node.val > parentVal && node.val < grandparentVal)
          && (helper(node.left, node.val, leftGrand, true)
              && helper(node.right, node.val, rightGrand, false));
    }
  }
}
