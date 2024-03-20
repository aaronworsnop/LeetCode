/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder serialisation = new StringBuilder();
    serDfs(root, serialisation);

    System.out.println(serialisation.toString());
    return serialisation.toString();
  }

  private void serDfs(TreeNode root, StringBuilder builder) {
    if (root == null) {
      builder.append("null,");
      return;
    }

    builder.append(root.val).append(",");
    serDfs(root.left, builder);
    serDfs(root.right, builder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }

    String[] stringData = data.split(",");
    Queue<String> queue = new LinkedList<>(Arrays.asList(stringData));

    return desDfs(queue);
  }

  private TreeNode desDfs(Queue<String> queue) {
    String value = queue.poll();
    if (value == null || value.equals("null")) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(value));
    node.left = desDfs(queue);
    node.right = desDfs(queue);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
