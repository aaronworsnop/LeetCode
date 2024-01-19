class Solution235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int qVal = q.val;
    int pVal = p.val;

    TreeNode current = root;

    // Traverse the tree to find the lower common ancestor
    while (current != null) {
      int currentVal = current.val;

      if (qVal < currentVal && pVal < currentVal) {
        // Both nodes are in the left sub-tree
        current = current.left;
      } else if (qVal > currentVal && pVal > currentVal) {
        // Both nodes are in the right sub-tree
        current = current.right;
      } else if (qVal < currentVal && pVal > currentVal || pVal < currentVal && qVal > currentVal) {
        // Found the lowest common ancestor
        break;
      } else {
        // The current node is p or q, we've found the lowest common ancestor
        break;
      }
    }

    return current;
  }
}
