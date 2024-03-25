/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();

    if (root == null) {
      return paths;
    }

    String rootPath = String.valueOf(root.val);

    if (root.left == null && root.right == null) {
      paths.add(rootPath);
    }

    if (root.left != null) {
      dfs(paths, root.left, rootPath);
    }

    if (root.right != null) {
      dfs(paths, root.right, rootPath);
    }

    return paths;
  }

  private void dfs(List<String> paths, TreeNode node, String currentPath) {
    currentPath += "->" + node.val;

    if (node.left == null && node.right == null) {
      paths.add(currentPath);
      return;
    }

    if (node.left != null) {
      dfs(paths, node.left, currentPath);
    }

    if (node.right != null) {
      dfs(paths, node.right, currentPath);
    }
  }
}
