class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ordering = new LinkedList<>();

        if (root == null) return ordering;
        dfs(root, ordering);
        return ordering;
    }

    private void dfs(Node node, List<Integer> ordering) {
        for (Node child : node.children) {
            dfs(child, ordering);
        }
        
        ordering.add(node.val);
    }
}
