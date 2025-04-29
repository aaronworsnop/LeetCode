class Solution {
    public List<Integer> postorder(Node root) {
        // any number of children is okay
        
        // left
        // right
        // print me
        
        //  3
        // / \
        //5   6
        // -> 5, 6, 3
        if (root == null) {
            return new LinkedList<>();
        }
        
        List<Integer> list = new LinkedList<>();
        
        if (root.children == null || root.children.isEmpty()) {
            list.add(root.val);
            return list;
        }
        
        for (Node child : root.children) {
            list.addAll(postorder(child));
        }
        
        list.add(root.val);
        return list;
        
    }
}
