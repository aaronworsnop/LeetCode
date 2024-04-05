class Solution100 {
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
