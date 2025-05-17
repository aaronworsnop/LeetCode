/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<TreeNode> output;
    
    public TreeNode increasingBST(TreeNode root) {
        this.output = new LinkedList<>();
        
        // In order traversal: left, me, right
        traversal(root);
        
        // Run through the list, creating our output        
        TreeNode dummy = new TreeNode();
        TreeNode current = dummy;
        for (TreeNode node : output) {
            current.right = node;
            node.left = null;
            
            current = current.right;
        }
        
        return dummy.right;
    }
    
    private void traversal(TreeNode node) {
        // Do an in-order traversal, keep track of the nodes in order in a global list
        if (node == null) return;
        
        // left
        traversal(node.left);
        
        // me
        output.add(node);
        
        // right
        traversal(node.right);
    }
}
