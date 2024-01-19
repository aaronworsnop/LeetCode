class Solution230 {
  public int kthSmallest(TreeNode root, int k) {
    // DFS to an ordered array then return the corrent index

    int kthSmallest = 0;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (!stack.isEmpty() || current != null) {
      // Go all the way to left, that will be the smallest

      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      current = stack.pop();
      kthSmallest++;

      if (kthSmallest == k) {
        return current.val;
      }

      // Once the is no more left, go right
      current = current.right;
    }

    return current.val;
  }
}
