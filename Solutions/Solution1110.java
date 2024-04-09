class Solution1110 {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    // positive integers
    // binary tree
    // TreeNode root, int[] to_delete -> List<TreeNode>
    // Entirely remove `to_delete` nodes

    //     1
    //   2   3
    //  4 5 6 7

    // forest: [1]

    // Create set of `to_delete`
    // int deletedSoFar, to break when we remove the right amount

    // to_delete: 3
    // remove parent.left/right (1.right)
    // check if either remove.left or remove.right are `to_delete` nodes
    // add remove.left + remove.right to the forest

    // SUCCESS
    //     1
    //   2   3   `to_delete`: 1, 2, 3, 4, 5, 6, 7
    //  4 5 6 7

    // SUCCESS
    // null

    // SUCCESS
    //     1
    //   2   3   `to_delete`: 3, 7
    //  4 5 6 7

    // Edge and known cases
    List<TreeNode> forest = new LinkedList<>();

    if (root == null) {
      // No trees in the forest
      return forest;
    } else if (to_delete.length == 0) {
      // No nodes removed, return our original tree
      forest.add(root);
      return forest;
    }

    // Initialise a set of nodes to delete
    Set<Integer> deleteSet = new HashSet<>();

    for (int node = 0; node < to_delete.length; node++) {
      deleteSet.add(to_delete[node]);
    }

    // deleteSet: 1, 2, 3, 4, 5, 6, 7
    // traversalQueue:
    // forest:

    // Execute a BFS traversal of the tree, deleting nodes when necessary
    Queue<TreeNode> traversalQueue = new LinkedList<>();
    traversalQueue.offer(root);

    if (!deleteSet.contains(root.val)) {
      forest.add(root);
    }

    while (!traversalQueue.isEmpty()) {
      int queueSize = traversalQueue.size();

      for (int count = 0; count < queueSize; count++) {
        TreeNode currentNode = traversalQueue.poll();

        if (deleteSet.contains(currentNode.val)) {
          // This node should be removed and the children may
          // need to be added to the forest

          if (currentNode.left != null) {
            traversalQueue.add(currentNode.left);
          }

          if (currentNode.right != null) {
            traversalQueue.add(currentNode.right);
          }

          if (currentNode.left != null && !deleteSet.contains(currentNode.left.val)) {
            // The left child shouldn't be removed
            forest.add(currentNode.left);
          }

          if (currentNode.right != null && !deleteSet.contains(currentNode.right.val)) {
            // The right child shouldn't be removed
            forest.add(currentNode.right);
          }

          currentNode.left = null;
          currentNode.right = null;

        } else {
          // This node doesn't need to be removed, but we may
          // need to cut off connections to children that do

          if (currentNode.left != null) {
            traversalQueue.add(currentNode.left);

            if (deleteSet.contains(currentNode.left.val)) {
              // Cut the connection to the left child
              currentNode.left = null;
            }
          }

          if (currentNode.right != null) {
            traversalQueue.add(currentNode.right);

            if (deleteSet.contains(currentNode.right.val)) {
              // Cut the connection to the left child
              currentNode.right = null;
            }
          }
        }
      }
    }

    return forest;
  }
}
