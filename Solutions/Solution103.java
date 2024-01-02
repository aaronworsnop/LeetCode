class Solution103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> order = new ArrayList<>();
    if (root == null) return order;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    boolean odd = false;

    while (!queue.isEmpty()) {
      int levelLength = queue.size();
      List<Integer> levelOrder = new ArrayList<>();

      for (int node = 0; node < levelLength; node++) {
        TreeNode current = queue.poll();
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        levelOrder.add(current.val);
      }

      if (!levelOrder.isEmpty()) {
        if (odd) Collections.reverse(levelOrder);
        order.add(levelOrder);
      }

      odd = !odd;
    }

    return order;
  }
}
