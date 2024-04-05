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

    int startingNode = subRoot.val;

    Queue<TreeNode> rootQueue = new LinkedList<>();
    rootQueue.offer(root);

    while (!rootQueue.isEmpty()) {
      int layerSize = rootQueue.size();

      for (int node = 0; node < layerSize; node++) {
        TreeNode current = rootQueue.poll();

        // Check if this is the subtree

        if (current.val == startingNode && isSameTree(current, subRoot)) {
          return true;
        }

        if (current.left != null) {
          rootQueue.offer(current.left);
        }

        if (current.right != null) {
          rootQueue.offer(current.right);
        }
      }
    }

    return false;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    // Is a BFS the same between them?

    if (p == null) {
      if (q == null) {
        return true;
      } else {
        return false;
      }
    }

    if (q == null) {
      if (p == null) {
        return true;
      } else {
        return false;
      }
    }

    Queue<TreeNode> queueP = new LinkedList<>();
    queueP.offer(p);

    Queue<TreeNode> queueQ = new LinkedList<>();
    queueQ.offer(q);

    while (!queueP.isEmpty()) {
      int layerSizeP = queueP.size();
      int layerSizeQ = queueQ.size();

      if (layerSizeQ != layerSizeP) {
        return false;
      }

      for (int node = 0; node < layerSizeP; node++) {
        TreeNode currentP = queueP.poll();
        TreeNode currentQ = queueQ.poll();

        if (currentP.val != currentQ.val) {
          return false;
        }

        if (currentP.left != null && currentQ.left == null
            || currentP.left == null && currentQ.left != null) {
          return false;
        }

        if (currentP.left != null) {
          queueP.offer(currentP.left);
          queueQ.offer(currentQ.left);
        }

        if (currentP.right != null && currentQ.right == null
            || currentP.right == null && currentQ.right != null) {
          return false;
        }

        if (currentP.right != null) {
          queueP.offer(currentP.right);
          queueQ.offer(currentQ.right);
        }
      }
    }

    return true;
  }
}
