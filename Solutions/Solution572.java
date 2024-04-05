class Solution572 {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // Do a BFS on the `root` tree until we find a node with the right starting value

    // Edge and known cases
    if (subRoot == null) {
      return true;
    }

    if (root == null) {
      if (subRoot == null) {
        return true;
      } else {
        return false;
      }
    }

    if (root.val == subRoot.val) {
      if (isSameTree(root, subRoot)) {
        return true;
      }
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if ((p == null || q == null)) {
      return false;
    } else if (p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
  }
}
