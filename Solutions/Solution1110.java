class Solution1110 {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> forest = new LinkedList<>();
    Set<Integer> deleteSet = new HashSet<>();

    int nodesToDelete = to_delete.length;
    for (int node = 0; node < nodesToDelete; node++) {
      deleteSet.add(to_delete[node]);
    }

    TreeNode result = delNodesHelper(root, forest, deleteSet);
    if (result != null) {
      forest.add(root);
    }

    return forest;
  }

  private TreeNode delNodesHelper(TreeNode node, List<TreeNode> forest, Set<Integer> deleteNodes) {
    if (node == null) {
      return null;
    }

    node.left = delNodesHelper(node.left, forest, deleteNodes);
    node.right = delNodesHelper(node.right, forest, deleteNodes);

    if (deleteNodes.contains(node.val)) {
      if (node.left != null) {
        forest.add(node.left);
      }

      if (node.right != null) {
        forest.add(node.right);
      }

      return null;
    } else {
      return node;
    }
  }
}
