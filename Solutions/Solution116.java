class Solution116 {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Node current = root;
    Node next = null;
    if (current.left != null) next = root.left;

    while (current != null && next != null) {
      current.left.next = current.right;
      if (current.next != null) {
        current.right.next = current.next.left;
      }

      current = current.next;
      if (current == null) {
        current = next;
        next = next.left;
      }
    }

    return root;
  }
}
