/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution102 {
  public boolean[] level = new boolean[11];

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> order = new ArrayList<>();
    if (root == null) return order;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int levelLength = queue.size();
      List<Integer> levelOrder = new ArrayList<>();

      for (int node = 0; node < levelLength; node++) {
        TreeNode current = queue.poll();
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        levelOrder.add(current.val);
      }

      if (!levelOrder.isEmpty()) order.add(levelOrder);
    }

    return order;
  }
}
