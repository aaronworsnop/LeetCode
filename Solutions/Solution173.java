class BSTIterator {
    private LinkedList<Integer> iterator;
    private int iteratorIndex = 0;

    public BSTIterator(TreeNode root) {
        this.iterator = new LinkedList<>();

        // Do all the heavy lifting here. Do a DFS in-order traversal, constructing a linked-list
        TreeNode current = root;
        Stack<TreeNode> parent = new Stack<>();

        while (current != null || !parent.isEmpty()) {
            while (current != null) {
                parent.push(current);
                current = current.left;
            }

            current = parent.pop();
            this.iterator.add(current.val);

            current = current.right;
        }
    }
    
    public int next() {
        if (iteratorIndex >= iterator.size()) {
            return Integer.MIN_VALUE;
        }

        return iterator.get(iteratorIndex++);
    }
    
    public boolean hasNext() {
        return iteratorIndex < iterator.size();
    }
}
