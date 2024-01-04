class Solution116 {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int queueSize = queue.size();

      for (int node = 0; node < queueSize; node++) {
        Node current = queue.poll();

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        if (node + 1 < queueSize) current.next = queue.peek();
      }
    }

    return root;
  }
}
