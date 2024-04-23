class Solution199 {
  private Set<Integer> heights;
  private List<Integer> rightSideView;

  public List<Integer> rightSideView(TreeNode root) {
    // Keep a "max to the right" variable
    // The length of the List<Integer> returned is going to be the height of the tree

    // Keep height, and add the first one seen at each height
    // Reverse pre-order traversal

    this.heights = new HashSet<>();
    this.rightSideView = new ArrayList<>();

    if (root == null) {
      return rightSideView;
    }

    reversePreOrder(root, 0);

    return rightSideView;
  }

  public void reversePreOrder(TreeNode node, int height) {
    if (node == null) {
      return;
    }

    if (!heights.contains(height)) {
      rightSideView.add(node.val);
      heights.add(height);
    }

    reversePreOrder(node.right, height + 1);
    reversePreOrder(node.left, height + 1);

    return;
  }
}
